package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.backend.api.api.services.MonCompteServices
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class RepositoryMonCompte @Inject constructor(
    private val clientDao: ClientDao
//    private val monCompteServices: MonCompteServices
)
{


    fun recupClientByLogin(loginClient : String) = clientDao.recupClientsByLogin(loginClient)
    /**
     * recuperer le client par rapport a son id
     */
    fun recupClient(idClient : Int) = clientDao.recupClient(idClient)

    /**
     * recuperer les informations d'un client authentifier
     */
    fun checkLogged() = clientDao.checkLogged()

    /**
     * modifier les information du client dans la base de donnees local
     */
    suspend fun modifierClient(client: ClientEntity) {
        //monCompteServices.modifierClient(client)
        clientDao.modifierClient(client)
    }


}