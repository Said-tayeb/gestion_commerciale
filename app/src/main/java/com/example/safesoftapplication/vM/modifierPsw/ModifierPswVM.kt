package com.example.safesoftapplication.vM.modifierPsw

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
import java.lang.Exception

class ModifierPswVM @ViewModelInject constructor(
    val clientDao : ClientDao,
    application : Application
) : AndroidViewModel(application)
{
    var pswClient : String = ""
    var confPswClient : String = ""

    var _message = MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message

    private var _succes = MutableLiveData<Boolean>(false)
    val succes : LiveData<Boolean>
        get() = _succes

    lateinit var client : ClientEntity

    /**
     * verifier le mot de passe introduit par l'utilisateur
     */
    fun verifierPsw() : Boolean{
        if (pswClient == ""){
            _message.value = "vous devez spécifié votre nouveau mot de passe"
            return false
        }else{
            if (confPswClient == ""){
                _message.value = "vous devez confirmer votre nouveau mot de passe"
                return false
            }else{
                if(pswClient.length < 5){
                    _message.value = "Votre mot de passe doit contenir au moins 5 caractéres"
                    return false
                }else{
                    if (pswClient != confPswClient){
                        _message.value = "vous devez verifier  votre mot de passe"
                        return false
                    }else {
                        return true
                    }
                }
            }
        }
    }

    /**
     * modifier les informations du client dans la base de donnees
     */
    suspend fun modifClient(clientEntity: ClientEntity) {
        clientDao.modifierClient(clientEntity)
        Log.d("baseDonnees", "modifier avec succee")
    }

    /**
     * recuperer le client
     */
    suspend fun recupClient() : ClientEntity{
        return clientDao.recupByLoged()
    }

    /**
     * gestion de clic sur le bouton valider
     */
    fun clicValider(){
        if (verifierPsw()){
            viewModelScope.launch {
                try {
                    client = recupClient()
                    var newclient = ClientEntity(
                        client.idClient,
                        client.loginClient,
                        pswClient,
                        client.emailClient,
                        client.nomClient,
                        client.prenomClient,
                        client.telephoneClient,
                        1
                    )
                    modifClient(newclient)
                    _message.value = "votre mot de passe à été modifier par succès"
                    _succes.value = true
                }catch (e : Exception){
                    _message.value = "Erreur de modification"
                }
            }
        }
    }
}