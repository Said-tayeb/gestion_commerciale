package com.example.safesoftapplication.vM.modifiCompte

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

class ModifCompteVM @ViewModelInject constructor(
    val clientDao : ClientDao,
    application : Application
) : AndroidViewModel(application)
{

    var nomClient = ""
    var prenomClient = ""
    var emailClient = ""
    var loginClient = ""
    var telClient = ""

    private var _message = MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message
    private var _succes = MutableLiveData<Boolean>(false)
    val succes : LiveData<Boolean>
        get() = _succes

    /**
     * recuperer le client
     */
    suspend fun recupClient() : ClientEntity{
        return clientDao.recupByLoged()
    }

    /**
     * modifier les informations du client dans la base de donnees
     */
    suspend fun modifClient(clientEntity: ClientEntity) {
            clientDao.modifierClient(clientEntity)
            Log.d("baseDonnees", "modifier avec succee")
    }

    suspend fun recupToutClientsBaseDonnees() = clientDao.recupToutClients()


    /**
     * gestionaire de clic sur le bouton modifier client
     */
    fun clicEnrg(){
        if (loginClient == "" && nomClient == "" && prenomClient == "" && emailClient == "" && telClient == ""){
            _message.value = "Vous devez au moins modifier quelque' chose"
        }else{
            try{
                viewModelScope.launch {
                    var clientEntity = recupClient()
                    var newLogin : String = clientEntity.loginClient
                    var newTel : String? = clientEntity.telephoneClient
                    var newNom : String = clientEntity.nomClient
                    var newPrenom : String = clientEntity.prenomClient
                    var newEmail : String = clientEntity.emailClient

                    if (loginClient != ""){
                        newLogin= loginClient
                    }
                    if (emailClient != ""){
                        newEmail = emailClient
                    }
                    if (telClient != ""){
                        newTel = telClient
                    }
                    if (nomClient != ""){
                        newNom = nomClient
                    }
                    if (prenomClient != ""){
                        newPrenom = prenomClient
                    }
                    var newClient = ClientEntity(
                        clientEntity.idClient,
                        newLogin,
                        clientEntity.pswClient,
                        newEmail,
                        newNom,
                        newPrenom,
                        newTel,
                        1
                    )
                    Log.d("baseDonnees", "________"+ newClient.telephoneClient)
                        modifClient(newClient)
                        _message.value = "votre compte a été modifier avec sucèe"
                        _succes.value = true
                }

            }catch (e : Exception){
                _message.value = "nom d'utilisateur d'éja existant"
            }
        }
    }

}