package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import retrofit2.Retrofit
import javax.inject.Inject


class CatalogueRepository @Inject constructor(private val catalogueDao: CatalogueDao) {

    fun getAllProduits() = catalogueDao.getAllProduits()


    fun connectAPI(){
        val retrofitInstance: Retrofit? = null



    }
}

