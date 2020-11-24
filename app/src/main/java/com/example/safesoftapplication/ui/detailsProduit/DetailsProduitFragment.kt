package com.example.safesoftapplication.ui.detailsProduit

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentDetailsProduitBinding
import com.example.safesoftapplication.vM.authVM.AuthentificationVMFactory
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM
import com.example.safesoftapplication.vM.detailsProduitVM.DetailsProduitVM
import com.example.safesoftapplication.vM.detailsProduitVM.DetailsProduitVMFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsProduitFragment : Fragment() {
    private  val viewModel: DetailsProduitVM by viewModels()

    private lateinit var binding: FragmentDetailsProduitBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentDetailsProduitBinding>(inflater,
            R.layout.fragment_details_produit,container,false)

        val args = DetailsProduitFragmentArgs.fromBundle(requireArguments())

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val produitDao = BaseDonneesLocal.getInstance(application).produitDao()
        val clientDao= BaseDonneesLocal.getInstance(application).clientDao()
        val panierDao= BaseDonneesLocal.getInstance(application).panierDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = DetailsProduitVMFactory(produitDao,clientDao,panierDao, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(DetailsProduitVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)

        binding.viewModel = viewModel


        binding.btnAjoutPanier.setOnClickListener {

        }




        binding.btnCommander.setOnClickListener {

        }

        binding.btnContact.setOnClickListener {
            var uri = "tel:0655365148"
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