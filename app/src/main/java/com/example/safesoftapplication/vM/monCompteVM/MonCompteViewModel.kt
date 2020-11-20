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

    private val _client = MutableLiveData<ClientEntity>()
    val client : LiveData<ClientEntity>
        get() = _client

    /**
     * recuperer le client de la base de donnees
     */
    fun recupClientDatabase() : LiveData<ClientEntity>{
//        var a = MutableLiveData<ClientEntity>()
//       clientDao.checkLogged().observeForever({
//           a.value = it
//        })
//        return a
        return clientDao.checkLogged()
    }

    /**
     * affecter les donnnes a la live data variable
     */
    fun recupClient(){
        _client.value = recupClientDatabase().value
        Log.d("baseDonnees", "_____"+ client.value?.nomClient)
    }

    /**
     * changer le champ LOGGED de la table client a 0
     */
    fun logoutDB(){
        viewModelScope.launch {
            clientDao.logOut()
        }
    }

    /**
     * gestion d'evenement de bouton modifier compte
     */
    fun clicModifierCompte(){
        Log.d("baseDonnees", "______"+ client.value?.telephoneClient)
    }
}