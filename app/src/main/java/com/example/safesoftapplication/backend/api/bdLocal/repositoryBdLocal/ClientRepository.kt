package com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal

import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class ClientRepository @Inject constructor(val clientDao: ClientDao)
{
    fun recupClient(idClient : Int) = clientDao.recupClient(idClient)
    suspend fun modifierClient(clientEntity: ClientEntity) = clientDao.modifierClient(clientEntity)

}