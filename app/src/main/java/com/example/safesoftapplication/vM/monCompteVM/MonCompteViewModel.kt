package com.example.safesoftapplication.vM.monCompteVM

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import kotlinx.coroutines.launch


class MonCompteViewModel@ViewModelInject constructor(
    val clientDao : ClientDao,
    application : Application
)  : AndroidViewModel(application) {

    private val clientEntity = ClientEntity(
        0,
        "aucun",
        "aucun",
        "aucun",
        "aucun",
        "aucun",
        "aucun",
        0
    )
    private val _client = MutableLiveData<ClientEntity>()
    val client : LiveData<ClientEntity>
        get() = _client
    var nomClient : String = ""+ client.value?.nomClient
    var prenomClient : String = "" + client.value?.prenomClient
    var emailClient : String = "" + client.value?.emailClient
    var telClient : String = "" + client.value?.telephoneClient
    var loginClient : String = "" + client.value?.loginClient

    /**
     * recuperer le client de la base de donnees
     */
    suspend fun recupClientDatabase() : ClientEntity?{
        return clientDao.checkLogged()
    }

    /**
     * affecter les donnnes a la live data variable
     */
    fun recupClient(){
        viewModelScope.launch {
            _client.value = recupClientDatabase()
            Log.d("baseDonnees", "_____"+ client.value?.nomClient)
        }
    }

//    suspend fun modifierClientBD(newClient : ClientEntity){
//        var newClient = client.value
//        if (newClient != null) {
//            clientDao.modifierClient(newClient)
//        }
//    }
//    /**
//     * modifier les informations d'un client dans la base de donnnees local
//     */
//    fun modifierClient(){
//        viewModelScope.launch {
//            client.value?.let {
//                modifierClientBD(it)
//            }
//        }
//    }

    /**
     * gestion d'evenement de bouton modifier compte
     */
    fun clicModifierCompte(){
        Log.d("baseDonnees", "______"+ client.value?.telephoneClient)
    }
}