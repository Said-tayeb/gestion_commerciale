package com.example.safesoftapplication.vM.catalogueVM

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.repository.CatalogueRepository

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