package com.example.safesoftapplication.vM.authVM

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import kotlinx.coroutines.launch


class AuthentifivationVM @ViewModelInject constructor(
     val dataBase : ClientDao,
     application: Application
) : AndroidViewModel(application){

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

    /**
     * recuperer le client de la base de donnees
     */
    suspend fun recupClientDatabase() : ClientEntity?{
        return dataBase.attemptLogin(loginClient, pswClient)
    }

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
     * changer le champ LOGGED de la table client à 1
     */
    fun logged(loginClient: String){
        viewModelScope.launch {
            dataBase.logged(loginClient)
        }
    }

    /**
     * gestion d'evenement de clic sur le bouton login
     */
    fun clicLogin(){
        viewModelScope.launch {
            _client.value = recupClientDatabase()
            Log.d("baseDonnees", "_client : "+ client.value?.loginClient)
            if (verifierLogin()){
                _messageLogin.value = "vous devez remplir tous les champs"
            }else{
                Log.d("baseDonnees", "client : "+ client.value?.loginClient)
                if (client.value?.loginClient == null){
                    _messageLogin.value = "Erreur d'authentification"
                }else{
                    dataBase.logged(loginClient)
                    _messageLogin.value = "Bonjour " + client.value?.prenomClient
                    _trouver.value = true
                }
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