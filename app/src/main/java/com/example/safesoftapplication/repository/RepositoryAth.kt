package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import javax.inject.Inject

class RepositoryAth @Inject constructor(
    private val clientDao: ClientDao
//   , private val authService: AuthServices
) {


}