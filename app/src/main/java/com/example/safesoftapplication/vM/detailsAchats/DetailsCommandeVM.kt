package com.example.safesoftapplication.vM.detailsAchats

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

class DetailsCommandeVM @ViewModelInject constructor(
    val commandesDao: CommandesDao,
    val produitDao: CatalogueDao,
    application: Application
) : AndroidViewModel(application) {

    /**
     * recuperer les information d'une commande de la base de donnees local
     */
    fun recupCommande(idCommande : Int) : LiveData<CommandeEntity>{
        return commandesDao.recupCommande(idCommande)
    }
}