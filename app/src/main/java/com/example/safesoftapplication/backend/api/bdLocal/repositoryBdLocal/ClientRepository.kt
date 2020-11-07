package com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal

import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class ClientRepository @Inject constructor(val clientDao: ClientDao) {

    /**
     * recuperer tous les clients
     */
    fun recupTousClients() = clientDao.recupToutClients()

    /**
     * recuperer un client par son id
     */
    fun recupClient(idClient: ClientEntity) = clientDao.recupClient(idClient)

    /**
     * modifier les information d'un client
     */
    suspend fun modifierClient(idClient: ClientEntity) = clientDao.modifierClient(idClient)

    /**
     * recuperer les informations d'un client a partir de son login
     */
    fun attemptLogin(loginClient: String) = clientDao.attemptLogin(loginClient)

    /**
     *
     */
    fun logOut() = clientDao.logOut()

}