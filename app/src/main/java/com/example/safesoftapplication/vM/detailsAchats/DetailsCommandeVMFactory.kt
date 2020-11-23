package com.example.safesoftapplication.vM.detailsAchats

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao

class DetailsCommandeVMFactory (
    private val commandesDao: CommandesDao,
    private val catalogueDao: CatalogueDao,
    private val application: Application
) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsCommandeVM::class.java)) {
            return DetailsCommandeVM(commandesDao,catalogueDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}