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
import com.example.safesoftapplication.vM.AuthentifivationVM
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.managers.ViewComponentManager

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var  viewModel: AuthentifivationVM
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )
        //initialiser le viewModel
        viewModel = ViewModelProvider(this).get(AuthentifivationVM::class.java)
        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)

//        binding.btnLogin.setOnClickListener {
//            eventBtnLogin()
//        }

        viewModel.messageLogin.observe(viewLifecycleOwner, Observer { newMessageLogin ->
             if (newMessageLogin != ""){
                 Toast.makeText(context, newMessageLogin, Toast.LENGTH_LONG).show()
             }
        })

        viewModel.btnInscription.observe(viewLifecycleOwner, Observer { newBtnInscription ->
            if (newBtnInscription){
                Toast.makeText(context,"Créer un compte", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)
            }
        })


        return binding.root
    }



//    /**
//     * gestion d'evenement pour le bouton Login
//      */
//    private fun eventBtnLogin() {
//        var bool = true
//        var client : ClientEntity
//        viewModel.verifierLogin()
//        viewModel.verfierChamps.observe(viewLifecycleOwner, Observer { newVerfierChamps ->
//            bool = newVerfierChamps
//        })
//        if (bool){
//            Toast.makeText(context, "vous devez remplir tous les champs", Toast.LENGTH_LONG).show()
//        }else{
//            viewModel.recupClient()
//            //observer la valeur de live data client
//            viewModel.client.observe(viewLifecycleOwner, Observer { newClient ->
//                client = newClient
//            })
//            if (viewModel.client.value == null){
////                    longToast("erreur d'authentification")
//                Toast.makeText(context, "Erreur d'authentification", Toast.LENGTH_LONG).show()
//                binding.idLogin.text = null
//                binding.idPSW.text = null
//            }else{
//                Toast.makeText(context, "Bonjour", Toast.LENGTH_LONG).show()
//                view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
//            }
//        }
//    }
//
//    /**
//     * gestion d'evenement pour le bouton Inscription
//     */
//    private fun eventBtnInscription() {
//        Toast.makeText(context,"Créer un compte", Toast.LENGTH_SHORT).show()
////            longToast("Créer un compte")
//        view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)
//    }
}