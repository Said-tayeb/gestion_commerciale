package com.example.safesoftapplication.ui.monCompte

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.FragmentSlideshowBinding
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonCompteFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentSlideshowBinding>(inflater,
            R.layout.fragment_slideshow,container,false)

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = MonCompteVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(MonCompteViewModel::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
        binding.vm = viewModel

        viewModel.recupClient()
//        viewModel.client.observe(viewLifecycleOwner, Observer<ClientEntity> {
//
//        })

        //gestion de clic bouton modifier compte
        binding.btnModifierCompte.setOnClickListener {
            
        }
        //gestion de clic bouton modifier mot de passe
        binding.btnModifierpsw.setOnClickListener {
            eventModifPsw()
            Log.d("clic", "_________clic")
        }

        return binding.root
    }

    /**
     * gestion d'evenement pour le bouton modifier mot de passe
     */
    private fun eventModifPsw() {
        view?.findNavController()?.navigate(R.id.action_monCompteFragment_to_modifierPswFragment)
    }
}