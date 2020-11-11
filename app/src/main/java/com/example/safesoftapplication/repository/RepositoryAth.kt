package com.example.safesoftapplication.repository

import android.service.carrier.CarrierMessagingClientService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class RepositoryAth @Inject constructor(
    private val clientDao: ClientDao
//    private val authService: AuthServices
) {


    /**
     * recuperer tous les clients de la base de donnees local
     */
    fun recupToutClient() = clientDao.recupToutClients()

    /**
     * recuperer un client par rapport a son login et mot de passe
     */
    fun attemptLogin(loginClient: String, pswClient : String):LiveData<ClientEntity>{
        return clientDao.attemptLogin(loginClient, pswClient)
    }





}