package com.example.safesoftapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.repository.CatalogueRepository


class CatalogueVM @ViewModelInject constructor(
    private val catalogueRepository: CatalogueRepository,
//    private val config: PagedList.Config,
    ) :BaseViewModel() {


    fun getAllProduits(): LiveData<List<ProduitEntity>> =
        catalogueRepository.getAllProduits()
}