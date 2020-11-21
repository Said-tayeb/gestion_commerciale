package com.example.safesoftapplication.vM.panier

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity

class MonPanierVM @ViewModelInject constructor(
    val panierDao: PanierDao,
    val clientDao: ClientDao,
    application: Application
) : AndroidViewModel(application)
{

    /**
     * verifier si le client et connecter ou non
     */
    fun recupClientDatabase() : LiveData<ClientEntity> {
        return clientDao.checkLogged()
    }

}