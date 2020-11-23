package com.example.safesoftapplication.ui.modifierPsw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.databinding.FragmentMesCommandesBinding
import com.example.safesoftapplication.databinding.FragmentModifierPswBinding
import com.example.safesoftapplication.vM.modifierPsw.ModifierPswVM
import com.example.safesoftapplication.vM.modifierPsw.ModifierPswVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteVMFactory
import com.example.safesoftapplication.vM.monCompteVM.MonCompteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModifierPswFragment : Fragment() {

    private lateinit var binding: FragmentModifierPswBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentModifierPswBinding>(inflater,
            R.layout.fragment_modifier_psw,container,false)

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = ModifierPswVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ModifierPswVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
        binding.viewModel = viewModel

        viewModel.message.observe(viewLifecycleOwner, Observer {
            if (it != ""){
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                viewModel.succes.observe(viewLifecycleOwner, Observer { newSucces ->
                    if (newSucces) {
                        view?.findNavController()
                            ?.navigate(R.id.action_modifierPswFragment_to_monCompteFragment)
                    }
                })

            }
        })

        return binding.root
    }

}