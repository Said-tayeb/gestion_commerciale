package com.example.safesoftapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList

class CatalogueVM @ViewModelInject constructor(
    private val catalogueRepository: CatalogueRepository,
    private val config: PagedList.Config
) :BaseViewModel() {

    val searchQuery = MutableLiveData<String>()
//    val productsList: LiveData<PagedList<ProduitEntity>> =
//        catalogueRepository.getAllProduits().toLiveData(config = config)


}