package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import javax.inject.Inject

class RepositoryMonCompte @Inject constructor(
    private val clientDao: ClientDao
//    private val monCompteServices: MonCompteServices
)
{

}