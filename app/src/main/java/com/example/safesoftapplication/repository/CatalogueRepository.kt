package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.api.services.CatalogueService
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import javax.inject.Inject


class CatalogueRepository @Inject constructor(
    private val catalogueDao: CatalogueDao
   , private val catalogueService: CatalogueService
)
{


    fun getAllProduits() = catalogueDao.getAllProduits()

    fun getAllProduitsServeur() = catalogueService.recupToutProduits()

    fun insertDBserver(products: Array<ProduitEntity>) = catalogueDao.addProduits(*products)






}

