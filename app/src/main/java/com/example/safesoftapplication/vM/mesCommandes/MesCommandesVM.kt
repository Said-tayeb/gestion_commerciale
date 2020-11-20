package com.example.safesoftapplication.vM.mesCommandes

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao

class MesCommandesVM @ViewModelInject constructor(
    val commandesDao: CommandesDao,
    application: Application
) : AndroidViewModel(application) {



}