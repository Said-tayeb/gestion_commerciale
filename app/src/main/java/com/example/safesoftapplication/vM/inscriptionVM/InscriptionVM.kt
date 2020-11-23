package com.example.safesoftapplication.vM.inscriptionVM

import android.app.Application
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.repository.repositoryInscription
import kotlinx.coroutines.launch

class InscriptionVM @ViewModelInject constructor(
    val clientDao : ClientDao,
    application : Application
) : AndroidViewModel(application)
{
    var loginClient : String =""
    var pswClient : String = ""
    var cPswClient : String = ""
    var emailClient : String = ""
    var nomClient : String = ""
    var prenomClient : String = ""
    var telephoneClient : String = ""
    var essai = "dddddddddd"

    private val _client = MutableLiveData<ClientEntity>()
    val client :LiveData<ClientEntity>
        get() = _client

    private val _message = MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message

    fun changeMessage(){
        if (_message.value != ""){
            _message.value = ""
        }
    }

    var succes = false

    /**
     * ajouter un client a la base de donnees
     */
    private suspend fun  ajoutClient(client : ClientEntity){
        clientDao.ajoutClient(client)
    }

    /**
     * verifier l'existance de l'utilisateur  dans la base de donnees
     */
    fun existe() : Boolean{
        return false
    }

    /**
     * gestion d'evenement pour le bouton inscription
     */
    fun clicBtnInscription() {
        if (loginClient == "" || pswClient == "" || cPswClient == "" || emailClient == "" || nomClient == "" || prenomClient == "") {
            //longToast("vous devez remplir tous les champs")
            _message.value = "vous devez remplir tous les champs"
        }else{
            if(pswClient.length < 5){
                _message.value = "votre mot de passe doit contenir au moins 5 caracteres"
            }else {
                if (cPswClient != pswClient) {
                    _message.value = "verifier votre mot de passe"
                } else{
                    if (existe()) {
                        _message.value = "utilisateur déja exitant"
                    } else {
                        //demarer une coroutine
                        viewModelScope.launch {
                            val newclient = ClientEntity(
                                0,
                                loginClient,
                                pswClient,
                                emailClient,
                                nomClient,
                                prenomClient,
                                telephoneClient,
                                1
                            )
                            try {
                                ajoutClient(newclient)
                                succes = true
                                _message.value = "Vous avez bien inscrit"
                            }catch (e : Exception){
                                _message.value = "nom d'utilisateur déja utilisé, Vous dever choisir un autre"
                            }
                        }
                    }
                }
            }
        }
    }
}
