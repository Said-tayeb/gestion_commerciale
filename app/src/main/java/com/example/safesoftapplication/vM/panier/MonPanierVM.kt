package com.example.safesoftapplication.vM.panier

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import kotlinx.coroutines.launch

class MonPanierVM @ViewModelInject constructor(
    val panierDao: PanierDao,
    val clientDao: ClientDao,
    application: Application
) : AndroidViewModel(application)
{

    var idClient : Int = 0

    /**
     * verifier si le client et connecter ou non
     */
    fun recupClientDatabase() : LiveData<ClientEntity> {
        return clientDao.checkLogged()
    }


    /**
     * ajout d'un produit au panier
     */
    fun ajoutProduitPanier(){
        var panier1 = PanierEntity(0,1, 1 , 9000.0)
        var panier2 = PanierEntity(0,1, 2 , 3000.0)
        viewModelScope.launch {
            panierDao.ajoutProdPanier(panier1)
            panierDao.ajoutProdPanier(panier2)
        }
    }

    /**
     * recuperer tous id client connecter
     */
    fun recupBD() {
        viewModelScope.launch {
            idClient = clientDao.recupIdClient()
        }
    }

    val panier = panierDao.recupTousPanier(1)

}
