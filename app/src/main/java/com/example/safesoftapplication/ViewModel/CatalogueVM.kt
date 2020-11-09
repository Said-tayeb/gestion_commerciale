package com.example.safesoftapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
<<<<<<< HEAD
import androidx.lifecycle.LiveData
import androidx.lifecycle.toPublisher
import androidx.paging.PagedList

import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.repository.CatalogueRepository
=======
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
>>>>>>> 87fd40798f2fd3a3db213f7a87dc0c4b77039567

class CatalogueVM @ViewModelInject constructor(
    private val catalogueRepository: CatalogueRepository,
//    private val config: PagedList.Config,
    ) :BaseViewModel() {


    fun getAllProduits(): LiveData<List<ProduitEntity>> =
        catalogueRepository.getAllProduits()
}