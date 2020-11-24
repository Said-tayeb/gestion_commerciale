package com.example.safesoftapplication.ui.detailsProduit

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentDetailsProduitBinding
import com.example.safesoftapplication.vM.detailsProduitVM.DetailsProduitVM
import com.example.safesoftapplication.vM.detailsProduitVM.DetailsProduitVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import com.google.android.material.snackbar.Snackbar
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
            viewModel.recupClient().observe(viewLifecycleOwner, Observer { newClient ->
                viewModel.recuProduitPanier(args.idProduit, newClient.idClient).observe(viewLifecycleOwner, Observer { newProduit ->
                    Log.d("baseDonnees", "_______idProduit = " + newProduit)
                    if(newProduit != null){
                        Snackbar.make(
                            requireActivity().findViewById(android.R.id.content),
                            "Vous avez déjà ajouté ce produit à votre panier",
                            Snackbar.LENGTH_SHORT // How long to display the message.
                        ).show()
                    }else{
                        viewModel.recupProduit(args.idProduit).observe(viewLifecycleOwner, Observer { produitAjout ->
                            viewModel.ajoutProduitPanier(produitAjout, newClient)
                            viewModel.message.observe(viewLifecycleOwner, Observer {
                                Snackbar.make(
                                    requireActivity().findViewById(android.R.id.content),
                                    it,
                                    Snackbar.LENGTH_SHORT // How long to display the message.
                                ).show()
                            })

                        })
                    }
                })
            })
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

        setHasOptionsMenu(true)

        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.panier_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}