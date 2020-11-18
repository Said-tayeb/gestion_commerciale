package com.example.safesoftapplication.vM.modifierPsw

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao

class ModifierPswVM @ViewModelInject constructor(
    val clientDao : ClientDao,
    application : Application
) : AndroidViewModel(application)
{



    fun clicValider(){

    }
}