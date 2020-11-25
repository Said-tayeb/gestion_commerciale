package com.example.safesoftapplication.vM.detailsProduitVM

import android.app.Application
import android.util.Log
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

//    private val _existPanier = MutableLiveData<Boolean>(null)
//    val existPanier : LiveData<Boolean>
//        get() = _existPanier

    var existPanier = true

    private val _message = MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message

//    lateinit var produit : ProduitEntity

    /**
     * recuperer les informations d'un client
     */
    fun recupClient() = clientDao.checkLogged()

    /**
     * recuperer les informations du produit
     */
    fun recupProduit(idProduit : Int) = produitDao.recupProduit(idProduit)

//    fun recupProduitEnt(idProduit: Int){
//        viewModelScope.launch {
//            produit = produitDao.recupProduitEnt(idProduit)
//        }
//    }

    /**
     * ajout d'un produit au panier d'un client
     */
    fun ajoutProduitPanier( clientEntity: ClientEntity, idProduit: Int){
        viewModelScope.launch {
            try {
                var produit = produitDao.recupProduitEnt(idProduit)
                var produiPanier = panierDao.recupProduitEntPanier(idProduit, clientEntity.idClient)
                if (produiPanier == null){
                    var panierEntity = PanierEntity(0,clientEntity.idClient, produit.idProduit, produit.prixProduit, produit.imageProduit)
                    panierDao.ajoutProdPanier(panierEntity)
                    _message.value = "Le produit à été ajouté à votre panier"
                }else{
                    _message.value = "Vous avez déjà ajouté ce produit à votre panier"
                }

            }catch (e : Exception){

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

    /**
     *
     */
    fun RecupProduitEntPanier(idProduit: Int, idClient : Int){
        viewModelScope.launch {
            try {
                var produit = panierDao.recupProduitEntPanier(idProduit, idClient)
                if (produit != null){
                    existPanier = true
                }else{
                    existPanier = false
                }
            }catch (e : Exception){
                Log.d("baseDonnees", "echec de recuperation")
            }
        }
    }

    fun renitMessage(){
        _message.value = ""
    }

    fun changeExist(){
        existPanier = true
    }

    /**
     * gestion d'evenement pour le clic Ajout panier
     */
    fun clicBtnAjoutPanier() {

    }

    /**
     * gestion d'evenement pour le clic faire une commande
     */
    fun clicCommander(){

    }
}