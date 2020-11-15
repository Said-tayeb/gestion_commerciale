package com.example.safesoftapplication.vM

import android.util.Log
import com.example.safesoftapplication.vM.BaseViewModel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse.produitsResponse
import com.example.safesoftapplication.backend.api.api.services.CatalogueService
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.repository.CatalogueRepository
import com.example.safesoftapplication.utils.Resource
import javax.inject.Named


class CatalogueVM @ViewModelInject constructor(
    private val catalogueRepository: CatalogueRepository

) : BaseViewModel() {

    fun getAllProduits(): LiveData<List<ProduitEntity>> =
        catalogueRepository.getAllProduits()

    fun affiche(){
        val data = getProduit()
        Log.d("data", "mes data  :"+data.value?.data?.get(0)?.idProduit)
    }


    fun getProduit(): LiveData<Resource<List<produitsResponse>>> {
        val data: MutableLiveData<Resource<List<produitsResponse>>> = MutableLiveData()
        enqueue(catalogueRepository.getAllProduitsServeur(), data)
        return data
    }




}