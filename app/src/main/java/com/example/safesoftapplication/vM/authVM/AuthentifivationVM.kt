package com.example.safesoftapplication.vM.authVM

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*

//import com.example.safesoftapplication.backend.api.api.repository.AuthRepository

//import com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal.ClientRepository


import com.example.safesoftapplication.repository.RepositoryAth
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.ui.authentification.LoginActivity
import kotlinx.coroutines.launch
import org.koin.dsl.module.applicationContext


class AuthentifivationVM @ViewModelInject constructor(
     val dataBase : ClientDao,
     application: Application
//     @Assisted savedStateHandle: SavedStateHandle
) : AndroidViewModel(application){
//    private var _loginClient = MutableLiveData<String>()
//    val loginClient : LiveData<String>
//        get() = _loginClient
//
//    private var _pswClient = MutableLiveData<String>()
//    val  pswClient : LiveData<String>
//        get() = _pswClient
    var loginClient : String = ""
    var pswClient : String = ""

    private val _client = MutableLiveData<ClientEntity>()
    val client : LiveData<ClientEntity>
        get() = _client

    private val _verifierChamps = MutableLiveData<Boolean>()
    val verifierChamps : LiveData<Boolean>
        get() = _verifierChamps

    private val _messageLogin = MutableLiveData<String>("")
    val messageLogin : LiveData<String>
    get() = _messageLogin

    private val _trouver = MutableLiveData<Boolean>(false)
    val trouver : LiveData<Boolean>
    get() = _trouver

    private val _btnInscription = MutableLiveData<Boolean>(false)
    val btnInscription : LiveData<Boolean>
        get() = _btnInscription

    /**
     * modifier la valeur de btnInscriiption
     */
    fun changeBtnInscription(){
        if(_btnInscription.value == true){
            _btnInscription.value = false
        }else{
            _btnInscription.value = true
        }
    }

    /**
     * changer la valeur de la variable trouver
     */
    fun changeTrouver(){
        if(_trouver.value == false){
            _trouver.value = true
        }else{
            _trouver.value = false
        }
    }

    /**
     * changer la valeur de la variable message
     */
    fun changeMessage(){
        if (_messageLogin.value != ""){
            _messageLogin.value = ""
        }
    }
//    suspend fun recupClient() : List<ClientEntity>{
//        var listClient : List<ClientEntity>
//        viewModelScope.launch {
//           return@launch dataBase.recupToutClients()
//            Log.d("baseDonnees", "_________  "+ listClient.get(0).loginClient)
//        }
//
//    }

//    fun essaif(): LiveData<ClientEntity>{
//    val client = ClientEntity(1,"said","said","said","said","said",1)
//        var essai : MutableLiveData<ClientEntity> = MutableLiveData()
//        essai.value=client
//    Log.d("viewModel", ""+ essai.value!!.loginClient)
//    return essai
//    }

    fun init(){
        Log.d("viewModel", "_________le view model")
    }

//    fun recupClient() : LiveData<List<ClientEntity>> {
//            return dataBase.recupToutClients()
//        Log.d("baseDonnees", "_______recupList clients")
//            //Log.d("baseDonnees", "le client :"+clientTest.value?.get(0)?.loginClient)
//    }


    /**
     * verifier c'est les champs sont vides
     */
    fun verifierLogin() : Boolean{
//        Log.d("viewModel", "______loginClient = "+loginClient)
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
        Log.d("viewModel", "clic sur le bouton login____"+loginClient )
        if (verifierLogin()){
            _messageLogin.value = "vous devez remplir tous les champs"
        }else{
//            val clientTest = dataBase.recupToutClients()

            Log.d("baseDonnees", "_________ ")
            if (client.value == null){
                _messageLogin.value = "Erreur d'authentification"
            }else{
                _messageLogin.value = "Bonjour " + client.value?.prenomClient
                _trouver.value = true
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