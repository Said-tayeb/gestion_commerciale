package com.example.safesoftapplication.vM

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData

//import com.example.safesoftapplication.backend.api.api.repository.AuthRepository

//import com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal.ClientRepository


import com.example.safesoftapplication.repository.RepositoryAth
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.ui.authentification.LoginActivity
import org.koin.dsl.module.applicationContext


class AuthentifivationVM @ViewModelInject constructor(
     val repositoryAth: RepositoryAth,
     val application: Application
//     @Assisted savedStateHandle: SavedStateHandle
) : ViewModel(){
     var loginClient : String = ""
    var pswClient : String = ""

    private val _client = MutableLiveData<ClientEntity>()
    val client : LiveData<ClientEntity>
        get() = _client

    private val _messageLogin = MutableLiveData<String>("")
    val messageLogin : LiveData<String>
    get() = _messageLogin

    private val _btnInscription = MutableLiveData<Boolean>(false)
    val btnInscription : LiveData<Boolean>
        get() = _btnInscription

    fun essaif(): LiveData<ClientEntity>{
    val client = ClientEntity(1,"said","said","said","said","said",1)
        var essai : MutableLiveData<ClientEntity> = MutableLiveData()
        essai.value=client
    Log.d("viewModel", ""+ essai.value!!.loginClient)
    return essai
    }


    fun init(){
        Log.d("viewModel", "_________le view model")
    }

    fun recupClient() {
        Log.d("viewModel", "_________le recupe")
//        client.value = repositoryAth.attemptLogin(loginClient, pswClient).value
        //_client.postValue(repositoryAth.attemptLogin(loginClient, pswClient).value)
        Log.d("viewModel", "=========="+ client.value?.loginClient)
    }

    /**
     * verifier c'est les champs sont vides
     */
    fun verifierLogin() : Boolean {
        if (loginClient == "" || pswClient == ""){
            return true
        }else{
            return false
        }
    }

    /**
     * gestion d'evenement de clic sur le bouton login
     */
    fun clicLogin(){
        if (verifierLogin()){
            _messageLogin.value = "vous devez remplir tous les champs"
        }else{
            recupClient()
            if (client.value == null){
                _messageLogin.value = "Erreur d'authentification"
            }else{
                _messageLogin.value = "Bonjour"
                //Toast.makeText(context, "Bonjour", Toast.LENGTH_LONG).show()
                //view?.findNavController()?.navigate(R.id.action_loginFragment_to_nav_gallery)
            }
        }
    }

    /**
     * gestion d'evenement de clic sur le bouton inscription
     */
    fun clicInscription(){
        _btnInscription.value = true
    }

}