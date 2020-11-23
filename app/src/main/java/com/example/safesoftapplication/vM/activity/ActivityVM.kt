package com.example.safesoftapplication.vM.activity

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import kotlinx.coroutines.launch

class ActivityVM @ViewModelInject constructor(
    val dataBase : ClientDao,
    application: Application
//     @Assisted savedStateHandle: SavedStateHandle
) : AndroidViewModel(application)
{

    fun logout() {
        viewModelScope.launch {
             dataBase.logOut()
        }
    }
}