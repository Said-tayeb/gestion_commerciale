package com.example.safesoftapplication.ui.monPanier

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentMonPanierBinding
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import com.example.safesoftapplication.vM.panier.MonPanierVM
import com.example.safesoftapplication.vM.panier.MonPanierVMFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonPanierFragment : Fragment() {

    private lateinit var binding: FragmentMonPanierBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMonPanierBinding>(
            inflater,
            R.layout.fragment_mon_panier, container, false
        )
        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val instace = BaseDonneesLocal.getInstance(application)
        val panierDao = instace.panierDao()
        val clientDao = instace.clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = MonPanierVMFactory(panierDao, clientDao, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(MonPanierVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel


        //verifier si l'utilisateur s'est déja authentifier
        viewModel.recupClientDatabase().observe(viewLifecycleOwner, Observer { client ->
            if (client == null) {
                view?.findNavController()?.navigate(R.id.action_nav_monPanier_to_loginFragment)
            } else {
                //creation de l'adapteur
                val adapter = MonPanierAdapter(PanierListener { idProduit ->
                    Log.d("baseDonnees", "______"+ idProduit)
                    viewModel.clicProduit(idProduit)
                    viewModel.navigateToDetailsProduit.observe(viewLifecycleOwner, Observer {
                        it?.let {
                            this.findNavController().navigate(
                                MonPanierFragmentDirections
                                    .actionMonPanierFragmentToDetailsProduitFragment(it))
                            viewModel.ProduitDetailsNavgated()
                        }
                    })
                }, PanierListenerDelete { idProduit ->
                    viewModel.supProduitPanier(idProduit)
                    viewModel.messageDelete.observe(viewLifecycleOwner, Observer { newMessage ->
                        Snackbar.make(
                            requireActivity().findViewById(android.R.id.content),
                            newMessage,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    })
                })

                binding.idRcyclerViewPanier.adapter = adapter

                viewModel.recupBD()

                viewModel.recupToutProdPanier(client.idClient).observe(viewLifecycleOwner, Observer {

                    it?.let {
                        adapter.submitList(it)
                    }
                })
                //gestionaire de clic de bouton ajouter
                binding.idCatalogue.setOnClickListener {
                    view?.findNavController()
                        ?.navigate(R.id.action_monPanierFragment_to_catalogueFragment)
                }
            }
        })

        val manager = GridLayoutManager(activity, 2)

        binding.idRcyclerViewPanier.layoutManager = manager

//        setHasOptionsMenu(true)

        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.panier_menu, menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        //referance a l application
//        val application = requireNotNull(this.activity).application
//        //referance a notre source de donnees
//        val instace = BaseDonneesLocal.getInstance(application)
//        val panierDao = instace.panierDao()
//        val clientDao = instace.clientDao()
//        //créez une instance du viewModelFactory
//        val viewModelFactory = MonPanierVMFactory(panierDao, clientDao, application)
//        //intance de view model (referance a notre view model)
//        val viewModel =
//            ViewModelProvider(
//                this, viewModelFactory).get(MonPanierVM::class.java)
//        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
//        binding.setLifecycleOwner(this)
//        when (item.itemId) {
//            R.id.itemSup -> {
//                var message : String
//                try {
//                    viewModel.supToutPanier()
//                    message = "Votre panier est vide"
//                }catch (e : Exception){
//                    message ="erreur"
//                }
//                    Snackbar.make(
//                        requireActivity().findViewById(android.R.id.content),
//                        message,
//                        Snackbar.LENGTH_SHORT // How long to display the message.
//                    ).show()
//                    viewModel.renitMessageSupTout()
//            }
//        }
//        return true
//    }

}