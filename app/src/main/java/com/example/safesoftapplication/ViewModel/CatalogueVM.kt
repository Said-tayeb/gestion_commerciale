package com.example.safesoftapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal.CatalogueRepository
import java.util.*

class CatalogueVM @ViewModelInject constructor(
    private val catalogueRepository: CatalogueRepository,
    private val config: PagedList.Config
) :BaseViewModel() {

    val searchQuery = MutableLiveData<String>()
//    val productsList: LiveData<PagedList<ProduitEntity>> =
//        catalogueRepository.getAllProduits().toLiveData(config = config)


}