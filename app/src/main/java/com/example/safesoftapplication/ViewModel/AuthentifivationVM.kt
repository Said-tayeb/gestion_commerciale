package com.example.safesoftapplication.ViewModel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.model.Client
import com.example.safesoftapplication.repository.RepositoryAth
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AuthentifivationVM @ViewModelInject constructor(
     val repositoryAth: RepositoryAth,
//     @Assisted savedStateHandle: SavedStateHandle
) : ViewModel(){
//    val client : LiveData<ClientEntity> = TODO()
    //recuperer les information des champs du l'activity authentification
//    val loginClient : String = savedStateHandle["loginClient"] ?: throw IllegalArgumentException("missing user LoginClient")
//    val pswClient : String = savedStateHandle["pswClient"] ?: throw IllegalArgumentException("missing user pswClient")
    lateinit var loginClient : String
    lateinit var pswClient : String

    fun init(){
        Log.d("viewModel", "_________le view model")
    }
    /**
     * passer les information du client a l'activity authentification
     */
//    fun recupClient() : LiveData<ClientEntity>{
////        var client : LiveData<ClientEntity>? = repositoryAth.attemptLogin(loginClient, pswClient)
//        client.value?.loginClient  = "said"
//        client.value?.pswClient = "said"
//        client.value?.LOGGED = "1"
//        client.value?.emailClient = "said@gmail.com"
//        client.value?.nomClient = "said"
//        client.value?.prenomClient = "tayeb"
//        client.value?.idClient = 1
//        return client
//    }



    /**
     * verifier les bonnes informations de login
     */
//    fun verifierLogin() : Boolean{
//        if (client == null){
//            return false
//        }else{
//            return true
//        }
//    }



}