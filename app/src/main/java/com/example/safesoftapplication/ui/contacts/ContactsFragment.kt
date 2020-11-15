package com.example.safesoftapplication.ui.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentContactsBinding
import com.example.safesoftapplication.databinding.FragmentDetailsAchatBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.vM.authVM.AuthentificationVMFactory
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM
import com.example.safesoftapplication.vM.contactVM.ContactVM
import com.example.safesoftapplication.vM.contactVM.ContactVMFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentContactsBinding>(inflater,
            R.layout.fragment_contacts,container,false)

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).infosOrganismeDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = ContactVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ContactVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
        binding.viewModel = viewModel
        return binding.root

    }

}