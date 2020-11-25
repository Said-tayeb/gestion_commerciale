package com.example.safesoftapplication.vM.detailsProduitVM

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsProduitVM @ViewModelInject constructor(
    val produitDao: CatalogueDao,
    val clientDao: ClientDao,
    val panierDao: PanierDao,
    application: Application
) : AndroidViewModel(application){

    private val _client = MutableLiveData<ClientEntity>()
    val client : LiveData<ClientEntity>
        get() = _client

    private val _existPanier = MutableLiveData<Boolean>(false)
    val existPanier : LiveData<Boolean>
        get() = _existPanier

    private val _message = MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message

    /**
     * recuperer les informations d'un client
     */
    fun recupClient() = clientDao.checkLogged()

    /**
     * recuperer les informations du produit
     */
    fun recupProduit(idProduit : Int) = produitDao.recupProduit(idProduit)

    /**
     * ajout d'un produit au panier d'un client
     */
    fun ajoutProduitPanier(produitEntity: ProduitEntity, clientEntity: ClientEntity){
        var panierEntity = PanierEntity(0,clientEntity.idClient, produitEntity.idProduit, produitEntity.prixProduit)
        viewModelScope.launch {
            try {
                panierDao.ajoutProdPanier(panierEntity)
                _message.value = "Le produit à été ajouté à votre panier"
            }catch (e : Exception){
                _message.value = "Echec d'ajout"
            }
        }
    }

    /**
     * recuperer un produit du panier du client
     */
    fun recuProduitPanier(idProduit: Int, idClient : Int) = panierDao.recupProduitPanier(idProduit,idClient)

    /**
     * ajouter la commande a la base de donnnees
     */
    fun ajoutCommande(produitEntity: ProduitEntity, clientEntity: ClientEntity){
        var commandeEntity = CommandeEntity(
            0,
            clientEntity.idClient,
            produitEntity.idProduit,
            "",
            "",
            0,
            0
        )
        viewModelScope.launch {

        }
    }

    fun RenitMessage(){
        _message.value = ""
    }

    /**
     * gestion devenement sur le clic du bouton ajout au panier
     */
    fun clicbtnAjoutPanier(idProduit: Int){

    }

    fun verifierPanier(idProduit: Int) : Boolean{
        TODO()
    }
}