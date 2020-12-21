package com.example.safesoftapplication.vM.panier

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao

class MonPanierVMFactory (
    private val panierDao: PanierDao,
    private val clientDao: ClientDao,
    private val application: Application
) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonPanierVM::class.java)) {
            return MonPanierVM(panierDao, clientDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}