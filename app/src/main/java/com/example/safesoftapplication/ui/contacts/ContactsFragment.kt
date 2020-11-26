package com.example.safesoftapplication.ui.contacts

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity
import com.example.safesoftapplication.databinding.FragmentContactsBinding
import com.example.safesoftapplication.vM.contactVM.ContactVM
import com.example.safesoftapplication.vM.contactVM.ContactVMFactory
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentContactsBinding>(
            inflater,
            R.layout.fragment_contacts, container, false
        )

        //referance a l application
        val application = requireNotNull(this.activity).application

        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).infosOrganismeDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = ContactVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ContactVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
        binding.viewModel = viewModel
         //recuperer les informations
        viewModel.recup()
        viewModel.infosOrganisme.observe(viewLifecycleOwner, Observer<InfosOrganismeEntity> {
            if(it != null) {
                binding.idAddresseOrganisme.text = "Adresse : " + it.adresseOrganisme
                binding.idCodePostalOrganisme.text = "Code postal : " + it.codePostalOrganisme
                binding.idEmailOrganisme.text = "Email : " + it.emailOrganisme
                binding.idNomOrganisme.text = "Nom : " + it.nomOrganisme
                binding.idTelephoneOrganisme.text = "Téléphone : " + it.telephoneOrganisme
            }

        })

        binding.fabTelephone.setOnClickListener {
            //val uri =Uri.parse("tel:0658164251")
            var uri = "tel:"+viewModel.telephoneOrganismeV
            val callIntent: Intent = Uri.parse(uri).let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            val mgr = application.getPackageManager()
            val activities: List<ResolveInfo> = mgr.queryIntentActivities(callIntent, 0)
            val isIntentSafe: Boolean = activities.isNotEmpty()
            if (isIntentSafe) {
                startActivity(callIntent)
            }
        }

        return binding.root
    }
}