package com.example.safesoftapplication.ui.authentification

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
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM
import com.example.safesoftapplication.databinding.FragmentLoginBinding
import com.example.safesoftapplication.vM.authVM.AuthentificationVMFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            "Vous dever connecter a votre compte",
            Snackbar.LENGTH_SHORT // How long to display the message.
        ).show()

        //referance a l application
        val application = requireNotNull(this.activity).application
        //referance a notre source de donnees
        val dataSource = BaseDonneesLocal.getInstance(application).clientDao()
        //créez une instance du viewModelFactory
        val viewModelFactory = AuthentificationVMFactory(dataSource, application)
        //intance de view model (referance a notre view model)
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(AuthentifivationVM::class.java)
        //Définissez l'activité actuelle en tant que propriétaire du cycle de vie de la liaison
        binding.setLifecycleOwner(this)
        //initialiser le viewModel
//        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
       binding.viewModel = viewModel


        //mettre à jour automatiquement les vues dans la mise en page
        //binding.lifecycleOwner = viewLifecycleOwner


//        binding.btnLogin.setOnClickListener {
//            eventBtnLogin()
//        }

//        binding.btnInscription.setOnClickListener {
//            eventBtnInscription()
//        }

        //gestion de button login
        viewModel.messageLogin.observe(viewLifecycleOwner, Observer<String> { newMessageLogin ->
             if (newMessageLogin != ""){
                 viewModel.trouver.observe(viewLifecycleOwner, Observer<Boolean>{newTrouver ->
                     if (newTrouver){
                         view?.findNavController()?.navigate(R.id.action_loginFragment_to_catalogueFragment)
                         viewModel.changeTrouver()
                     }else{
                         binding.idLogin.text = null
                         binding.idPSW.text = null
                     }
                 })
                 Toast.makeText(context, newMessageLogin, Toast.LENGTH_LONG).show()
                 viewModel.changeMessage()
             }
        })
        //gestion de button inscription
        viewModel.btnInscription.observe(viewLifecycleOwner, Observer<Boolean> { newBtnInscription ->
            if (newBtnInscription){
                view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)
                viewModel.changeBtnInscription()
            }
        })
        return binding.root
    }

    /**
     * gestion d'evenement pour le bouton Login
      */
//    private fun eventBtnLogin() {
//        if (viewModel.verifierLogin()) {
//        } else {
//            viewModel.recupClient()
//            //observer la valeur de live data client
//            Toast.makeText(context, "vous devez remplir tous les champs", Toast.LENGTH_LONG).show()
//            viewModel.client.observe(viewLifecycleOwner, Observer<ClientEntity> { newClient ->
//                Log.d("viewModel", "______newLoginClient : " + newClient.loginClient)
//                if (newClient.loginClient == "") {
////                    longToast("erreur d'authentification")
//                    Toast.makeText(context, "Erreur d'authentification", Toast.LENGTH_LONG).show()
////                    binding.idLogin.text = null
////                    binding.idPSW.text = null
//                } else {
//                    Toast.makeText(context, "Bonjour "+ newClient.prenomClient, Toast.LENGTH_LONG).show()
//                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
//                }
//            })
//        }
//    }

//        viewModel.verifierChamps.observe(viewLifecycleOwner, Observer { newVerfierChamps ->
//            Log.d("viewModel", "______newLoginClient : " + newVerfierChamps)
//            if (newVerfierChamps){
//                Toast.makeText(context, "vous devez remplir tous les champs", Toast.LENGTH_LONG).show()
//            }else{
//                viewModel.recupClient()
//                //observer la valeur de live data client
//                viewModel.client.observe(viewLifecycleOwner, Observer { newClient ->
//                    Log.d("viewModel", "______newLoginClient : " + newClient.loginClient)
//                    Log.d("viewModel", "______newLoginClient : " + newClient.loginClient)
//                    if (true){
////                    longToast("erreur d'authentification")
//                        Toast.makeText(context, "Erreur d'authentification", Toast.LENGTH_LONG).show()
//                        binding.idLogin.text = null
//                        binding.idPSW.text = null
//                    }else{
//                        Toast.makeText(context, "Bonjour", Toast.LENGTH_LONG).show()
//                        view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
//                    }
//                })
//                view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
//            }
//        })

//    }

    /**
     * gestion d'evenement pour le bouton Inscription
     */
//    private fun eventBtnInscription() {
//        Toast.makeText(context,"Créer un compte", Toast.LENGTH_SHORT).show()
////            longToast("Créer un compte")
//        view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)
//    }

}