package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import javax.inject.Inject

class RepositoryPanier @Inject constructor(
    private val panierDao: PanierDao
)
{
    
}