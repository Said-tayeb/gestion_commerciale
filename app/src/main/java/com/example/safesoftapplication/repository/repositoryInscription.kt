package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.backend.api.api.services.InscriptionServices
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class repositoryInscription @Inject constructor(
    private val clientDao: ClientDao
//    private val inscriptionServices: InscriptionServices
)
{
    /**
     * recuperer les informations d'un client authentifié
     */
    fun checkLogged() = clientDao.checkLogged()

    /**
     * ajout d'un client a la base de donnees local
     */
    fun ajoutClient(client : ClientEntity){
//        try {
//            clientDao.ajoutClient(client)
//        }catch ( ){
//
//        }
    }
}