package com.example.safesoftapplication.ui.monCompte

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.FragmentSlideshowBinding
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import com.google.android.material.snackbar.Snackbar
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

        binding.vm = viewModel

        //recuperer le compte de client
        viewModel.recupClientDatabase().observe(viewLifecycleOwner, Observer {
            if(it == null){
                view?.findNavController()?.navigate(R.id.action_nav_monCompte_to_loginFragment)
            }else{
                Log.d("baseDonnees", "________telephone"+ it.telephoneClient)
                binding.apply {
                    editNomClient.text = it.nomClient
                    editTextEmailClient.text = it.emailClient
                    editPrenomClient.text = it.prenomClient
                    if (it.telephoneClient != null){
                        editTelClient.text = it.telephoneClient
                    }else{
                        editTelClient.text = "aucun"
                    }
                    editLoginClient.text = it.loginClient
                    invalidateAll()
                }
            }
            //gestion de clic bouton modifier compte
            binding.btnModifierCompte.setOnClickListener {
                eventModifCompte()
            }

            //gestion de clic bouton modifier mot de passe
            binding.btnModifierpsw.setOnClickListener {
                eventModifPsw()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun eventModifCompte() {
        view?.findNavController()?.navigate(R.id.action_monCompteFragment_to_modifCompteFragment)
    }

    /**
     * gestion d'evenement pour le bouton modifier mot de passe
     */
    private fun eventModifPsw() {
        view?.findNavController()?.navigate(R.id.action_monCompteFragment_to_modifierPswFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.accueil, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
        when (item.itemId) {
            R.id.homeFragment -> {
                viewModel.logoutDB()
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "Vous être déconnecter",
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        }
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)


    }

}