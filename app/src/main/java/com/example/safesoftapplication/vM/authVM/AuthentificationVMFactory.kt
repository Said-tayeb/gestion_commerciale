package com.example.safesoftapplication.vM.authVM

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao

class AuthentificationVMFactory(
    private val dataSource: ClientDao,
    private val application: Application
) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthentifivationVM::class.java)) {
            return AuthentifivationVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}