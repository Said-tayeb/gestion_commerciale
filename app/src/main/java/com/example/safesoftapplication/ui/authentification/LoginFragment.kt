package com.example.safesoftapplication.ui.authentification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.safesoftapplication.AccueilActivity
import com.example.safesoftapplication.R
import com.example.safesoftapplication.ViewModel.AuthentifivationVM
import com.example.safesoftapplication.databinding.FragmentHomeBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: AuthentifivationVM by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )
        binding.setLifecycleOwner(this)

        binding.btnLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
            if (viewModel.verifierLogin()){
//                longToast("vous devez remplir tous les champs")
            }else{
                if (viewModel.recupClient().value == null){
//                    longToast("erreur d'authentification")
                }else{
//                  longToast("Bonjour")
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)
                }
            }
        }

        binding.btnInscription.setOnClickListener {
//            Toast.makeText(this,"Créer un compte", Toast.LENGTH_SHORT).show()
//            longToast("Créer un compte")
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_inscriptionFragment)

        }

        return binding.root
    }

}