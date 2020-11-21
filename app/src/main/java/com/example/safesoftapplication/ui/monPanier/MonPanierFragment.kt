package com.example.safesoftapplication.ui.monPanier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentMonPanierBinding
import com.example.safesoftapplication.vM.panier.MonPanierVM
import com.example.safesoftapplication.vM.panier.MonPanierVMFactory
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


        //verifier c'est l'utilisateur a déja authentifier
        viewModel.recupClientDatabase().observe(viewLifecycleOwner, Observer {
            if (it == null) {
                view?.findNavController()?.navigate(R.id.action_nav_monPanier_to_loginFragment)
            } else {
                //creation de l'adapteur
//                val adapter = MesCommandesAdapter(CommandeListener { idCommande ->
//                    Log.d("baseDonnees", "_______clic")
//                    Toast.makeText(context, "${idCommande}", Toast.LENGTH_LONG).show()
//                })
//
//                //Associez le adapter avec le RecyclerView
//                binding.idRcyclerViewCommandes.adapter = adapter
//
//                //observer la liste des commandes
//                viewModel.recupToutCommandes().observe(viewLifecycleOwner, Observer {
//                    //affecter la valeur a l'adapteur
//                    it?.let {
//                        adapter.submitList(it)
//                    }
//                })

                val adapter = MonPanierAdapter()

                binding.idRcyclerViewPanier.adapter = adapter

//                viewModel.ajoutProduitPanier()
                viewModel.recupBD()

                viewModel.panier.observe(viewLifecycleOwner, Observer {

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

        return binding.root
    }
}