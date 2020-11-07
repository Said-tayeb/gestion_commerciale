package com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal

import androidx.lifecycle.LiveData
import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import io.reactivex.Flowable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val clientDao: ClientDao
)
{

    /**
     * recuperer les informations d'un client
     */
    fun recupClient(idClient : Int) = clientDao.recupClient(idClient)

    /**
     * modifier un client
     */
    suspend fun modifierClient(clientEntity: ClientEntity) = clientDao.modifierClient(clientEntity)

    /**
     * deconnecter un client
     */
    fun logOut() = clientDao.logOut()

}

