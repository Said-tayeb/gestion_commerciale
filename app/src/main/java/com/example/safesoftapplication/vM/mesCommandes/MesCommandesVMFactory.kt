package com.example.safesoftapplication.vM.mesCommandes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao

class MesCommandesVMFactory(
    private val commandesDao: CommandesDao,
    private val clientDao: ClientDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MesCommandesVM::class.java)) {
            return MesCommandesVM(commandesDao, clientDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}