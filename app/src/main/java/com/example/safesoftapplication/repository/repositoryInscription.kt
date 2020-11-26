package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import javax.inject.Inject

class repositoryInscription @Inject constructor(
    private val clientDao: ClientDao
//    private val inscriptionServices: InscriptionServices
)
{

}