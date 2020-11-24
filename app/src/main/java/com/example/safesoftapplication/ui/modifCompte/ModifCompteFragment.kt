package com.example.safesoftapplication.ui.modifCompte

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentModifCompteBinding
import com.example.safesoftapplication.databinding.FragmentSlideshowBinding
import com.example.safesoftapplication.vM.modifiCompte.ModifCompteVM
import com.example.safesoftapplication.vM.modifiCompte.ModifCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModifCompteFragment : Fragment() {

    private lateinit var binding: FragmentModifCompteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentModifCompteBinding>(inflater,
            R.layout.fragment_modif_compte,container,false)

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = ModifCompteVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ModifCompteVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel


        viewModel.message.observe(viewLifecycleOwner, Observer {
            if (it != ""){
                    viewModel.succes.observe(viewLifecycleOwner, Observer { newSucces ->
                        if (newSucces) {
                            view?.findNavController()
                                ?.navigate(R.id.action_modifCompteFragment_to_monCompteFragment)
                        }
                    })
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        //recuperer le compte de client

//        viewModel.recupClientDatabase().observe(viewLifecycleOwner, Observer {
//
//        })

        //gestion de clic bouton valider
//        binding.btnEnregistrer.setOnClickListener {
//            eventModifCompte()
//        }

        return binding.root
    }

    private fun eventModifCompte() {

    }



}