package com.example.safesoftapplication.ui.detailsAchat

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentDetailsAchatBinding
import com.example.safesoftapplication.vM.detailsAchats.DetailsCommandeVM
import com.example.safesoftapplication.vM.detailsAchats.DetailsCommandeVMFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsAchatFragment : Fragment() {

    private lateinit var binding: FragmentDetailsAchatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDetailsAchatBinding>(
            inflater,
            R.layout.fragment_details_achat, container, false
        )

        val args = DetailsAchatFragmentArgs.fromBundle(requireArguments())

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val commandeDao = BaseDonneesLocal.getInstance(application).commandesDao()
        val catalogueDao = BaseDonneesLocal.getInstance(application).produitDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = DetailsCommandeVMFactory(commandeDao, catalogueDao, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(DetailsCommandeVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        viewModel.recupCommande(args.idCommande).observe(
            viewLifecycleOwner,
            Observer { newCommande ->
                binding.apply {
                    txtDateCommande.text = newCommande.dateCommande
                    txtPrixTotal.text = newCommande.prixTotalCommande.toString() + " Da"
                    txtDateExp.text = newCommande.dateExpCommande
                    txtQuantite.text = newCommande.quantiteProduit.toString()
                }
            })

        binding.idModifierCommande.setOnClickListener {
//            val alertDialog: AlertDialog? = activity?.let {
//                val builder = AlertDialog.Builder(it)
//                builder.apply {
//                    setPositiveButton("OK",
//                        DialogInterface.OnClickListener { dialog, id ->
//                            // User clicked OK button
//                        })
//                    setNegativeButton("Annuler",
//                        DialogInterface.OnClickListener { dialog, id ->
//                            // User cancelled the dialog
//                        })
//                }
//                // Set other dialog properties
//
//                // Create the AlertDialog
//                builder.create()
//
//
//            }

            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Alert")
            builder.setMessage("Vous vouler bien modifier votre compte")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(context,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(context,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Maybe") { dialog, which ->
                Toast.makeText(context,
                    "Maybe", Toast.LENGTH_SHORT).show()
            }
            builder.show()

//            val builder1 = AlertDialog.Builder(context)
//            builder1.setMessage("Write your message here.")
//            builder1.setCancelable(true)
//
//            builder1.setPositiveButton(
//                "Yes"
//            ) { dialog, id -> dialog.cancel() }
//
//            builder1.setNegativeButton(
//                "No"
//            ) { dialog, id -> dialog.cancel() }
//
//            val alert11 = builder1.create()
//            alert11.show()
        }

        return binding.root

    }
}