package com.example.safesoftapplication.ui.inscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.vM.inscriptionVM.InscriptionVM
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.vM.inscriptionVM.InscriptionVMFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InscriptionFragment : Fragment() {

    private lateinit var binding: FragmentInscriptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate<FragmentInscriptionBinding>(inflater,
            R.layout.fragment_inscription,container,false)

        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            "Créer un compte",
            Snackbar.LENGTH_SHORT
        ).show()
        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = InscriptionVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(InscriptionVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
        binding.viewModel = viewModel

        //gestion de button enregistrer
        viewModel.message.observe(viewLifecycleOwner, Observer<String>{ newMessage ->
            if (newMessage != ""){
                if (viewModel.succes){
                    view?.findNavController()?.navigate(R.id.action_inscriptionFragment_to_catalogueFragment)
                }
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    newMessage,
                    Snackbar.LENGTH_LONG // How long to display the message.
                ).show()
                viewModel.changeMessage()
            }
        })
        return binding.root
    }
}