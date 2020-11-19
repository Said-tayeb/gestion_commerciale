package com.example.safesoftapplication.vM.modifiCompte

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.vM.modifierPsw.ModifierPswVM

class ModifCompteVMFactory (
    private val dataSource: ClientDao,
    private val application: Application
) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ModifCompteVM::class.java)) {
            return ModifCompteVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}