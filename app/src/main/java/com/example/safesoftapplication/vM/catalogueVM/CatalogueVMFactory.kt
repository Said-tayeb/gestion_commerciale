package com.example.safesoftapplication.vM.catalogueVM

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.api.services.CatalogueService
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.repository.CatalogueRepository
import com.example.safesoftapplication.vM.panier.MonPanierVM

class CatalogueVMFactory (
    private val catalogueRepo: CatalogueRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatalogueVM::class.java)) {
//            return CatalogueVM(catalogueRepo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}