package com.example.safesoftapplication.vM.detailsProduitVM

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM

class DetailsProduitVMFactory (
    private val produitDao : CatalogueDao,
    private val clientDao: ClientDao,
    private val panierDao: PanierDao,
    private val application: Application
) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsProduitVM::class.java)) {
            return DetailsProduitVM(produitDao,clientDao, panierDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}