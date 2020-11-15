package com.example.safesoftapplication.ui.inscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.vM.inscriptionVM.InscriptionVM
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.vM.authVM.AuthentificationVMFactory
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM
import com.example.safesoftapplication.vM.inscriptionVM.InscriptionVMFactory
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InscriptionFragment : Fragment() {

    private lateinit var binding: FragmentInscriptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate<FragmentInscriptionBinding>(inflater,
            R.layout.fragment_inscription,container,false)

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
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
        binding.viewModel = viewModel

        viewModel.message.observe(viewLifecycleOwner, Observer<String>{ newMessage ->
            if (viewModel.succes){
                view?.findNavController()?.navigate(R.id.action_inscriptionFragment_to_catalogueFragment)
            }
            if (newMessage != ""){
                Toast.makeText(context, newMessage, Toast.LENGTH_LONG).show()
//                if (viewModel.succes){
//                    view?.findNavController()?.navigate(R.id.action_homeFragment_to_catalogueFragment)
//                }
            }
        })
        return binding.root
    }

//    /**
//     * gestion d'evenement pour le bouton inscription
//     */
//    fun even(){
//        var loginClient = binding.editTextLoginInscription.text.toString()
//        var pswClient = binding.editTextPasswordInscription.text.toString()
//        var cPswClient = binding.editTextConfirmePassword.text.toString()
//        var emailClient = binding.editTextEmail.text.toString()
//        var nomClient = binding.editTextNomonCompte.text.toString()
//        var prenomClient = binding.editTextPrenom.text.toString()
//        if (loginClient == "" || pswClient == "" || cPswClient == "" || emailClient == "" || nomClient == "" || prenomClient == ""){
//            //longToast("vous devez remplir tous les champs")
//            Toast.makeText(context, "vous devez remplir tous les champs", Toast.LENGTH_LONG).show()
//        }else{
//            if (cPswClient == pswClient){
//                var clientEntity = ClientEntity(1,loginClient, pswClient, emailClient, nomClient, prenomClient, 1 )
//                //Log.d("viewModel", "=========" + viewModel.essai)
//                if (true){
//                    //longToast("Vous avez bien inscrit")
//                    Toast.makeText(context, "Vous avez bien inscrit", Toast.LENGTH_LONG).show()
//                    //executer l'action fragment inscription vers fragment catalogue
//                    view?.findNavController()?.navigate(R.id.action_inscriptionFragment_to_nav_gallery)
//                }else{
//                    //longToast("utilisateur déja exitant")
//                    Toast.makeText(context, "utilisateur déja exitant", Toast.LENGTH_LONG).show()
//                }
//            }else{
//                //longToast("verifier votre mot de passe")
//                Toast.makeText(context, "verifier votre mot de passe", Toast.LENGTH_LONG).show()
//            }
//        }
//    }
}