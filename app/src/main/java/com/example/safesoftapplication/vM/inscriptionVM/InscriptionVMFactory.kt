package com.example.safesoftapplication.vM.inscriptionVM

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.vM.authVM.AuthentifivationVM

class InscriptionVMFactory (
    val dataSource : ClientDao,
    private val application: Application
) : ViewModelProvider.Factory

{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InscriptionVM::class.java)) {
            return InscriptionVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}