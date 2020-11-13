package com.example.safesoftapplication.ui.inscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.vM.InscriptionVM
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.ActivityInsriptionBinding
import com.example.safesoftapplication.databinding.FragmentDetailsAchatBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InscriptionFragment : Fragment() {

    private val viewModel: InscriptionVM by viewModels()
    private lateinit var binding: FragmentInscriptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate<FragmentInscriptionBinding>(inflater,
            R.layout.fragment_inscription,container,false)

        binding.btnEnregistrer.setOnClickListener {
            even()
        }
        return binding.root

    }

    /**
     * gestion d'evenement pour le bouton inscription
     */
    fun even(){
        var loginClient = binding.editTextLoginInscription.text.toString()
        var pswClient = binding.editTextPasswordInscription.text.toString()
        var cPswClient = binding.editTextConfirmePassword.text.toString()
        var emailClient = binding.editTextEmail.text.toString()
        var nomClient = binding.editTextNomonCompte.text.toString()
        var prenomClient = binding.editTextPrenom.text.toString()
        if (loginClient == "" || pswClient == "" || cPswClient == "" || emailClient == "" || nomClient == "" || prenomClient == ""){
            //longToast("vous devez remplir tous les champs")
            Toast.makeText(context, "vous devez remplir tous les champs", Toast.LENGTH_LONG).show()
        }else{
            if (cPswClient == pswClient){
                var clientEntity = ClientEntity(1,loginClient, pswClient, emailClient, nomClient, prenomClient, 1 )
                //Log.d("viewModel", "=========" + viewModel.essai)
                if (true){
                    //longToast("Vous avez bien inscrit")
                    Toast.makeText(context, "Vous avez bien inscrit", Toast.LENGTH_LONG).show()
                    //executer l'action fragment inscription vers fragment catalogue
                    view?.findNavController()?.navigate(R.id.action_inscriptionFragment_to_nav_gallery)
                }else{
                    //longToast("utilisateur déja exitant")
                    Toast.makeText(context, "utilisateur déja exitant", Toast.LENGTH_LONG).show()
                }
            }else{
                //longToast("verifier votre mot de passe")
                Toast.makeText(context, "verifier votre mot de passe", Toast.LENGTH_LONG).show()
            }
        }
    }

}