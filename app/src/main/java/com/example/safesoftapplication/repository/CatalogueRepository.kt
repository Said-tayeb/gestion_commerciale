package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.api.services.CatalogueService
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import javax.inject.Inject


class CatalogueRepository @Inject constructor(
    private val catalogueDao: CatalogueDao
   , private val catalogueService: CatalogueService
//   , private val bdDistantModules: BDDistantModules
)
{
//     val url = "http://192.168.1.117/api/"

    fun getAllProduits() = catalogueDao.getAllProduits()


    fun getAllProduitsServeur() = catalogueService.recupToutProduits()





//



//    fun <T> createRetrofitService(clazz: Class<T>?, endPoint: String?): T {
//        val restAdapter: Retrofit = Retrofit.Builder()
//            .baseUrl(endPoint)
//            .build()
//        return restAdapter.create(clazz)
//    }



}

