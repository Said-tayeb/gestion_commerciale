package com.example.safesoftapplication.ui.mesCommandes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentMesCommandesBinding
import com.example.safesoftapplication.vM.mesCommandes.MesCommandesVM
import com.example.safesoftapplication.vM.mesCommandes.MesCommandesVMFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MesCommandesFragment : Fragment() {

    private lateinit var binding: FragmentMesCommandesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMesCommandesBinding>(inflater,
            R.layout.fragment_mes_commandes,container,false)

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val instace = BaseDonneesLocal.getInstance(application)
        val commandeDao = instace.commandesDao()
        val clientDao = instace.clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = MesCommandesVMFactory(commandeDao, clientDao, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(MesCommandesVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

//        viewModel.ajoutCommande()

        //verifier c'est l'utilisateur a déja authentifier
        viewModel.recupClientDatabase().observe(viewLifecycleOwner, Observer {
            if(it == null){
                view?.findNavController()?.navigate(R.id.action_nav_mesCommandes_to_loginFragment)
            }else{
                //creation de l'adapteur
                val adapter = MesCommandesAdapter(CommandeListener { idCommande ->
                    Log.d("baseDonnees", "_______clic")
                    viewModel.commandeClic(idCommande)
                    viewModel.navigation.observe(viewLifecycleOwner, Observer {
                        it?.let {
                            this.findNavController().navigate(
                                MesCommandesFragmentDirections
                                    .actionNavMesCommandesToDetailsAchatFragment(it))
                            viewModel.onNavigationToDetailsAchat()
                        }
                    })

                })

                //Associez le adapter avec le RecyclerView
                binding.idRcyclerViewCommandes.adapter = adapter

                //observer la liste des commandes
                viewModel.recupToutCommandes().observe(viewLifecycleOwner, Observer {
                    //affecter la valeur a l'adapteur
                    it?.let {
                        adapter.submitList(it)
                    }
                })

                //gestionaire de clic de bouton ajouter
                binding.idCatalogue.setOnClickListener {
                    view?.findNavController()?.navigate(R.id.action_mesCommandesFragment_to_catalogueFragment)
                }
            }
        })

        return binding.root
    }
}