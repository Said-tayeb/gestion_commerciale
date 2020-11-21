package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity

@Dao
interface PanierDao {

    /**
     * recuperer tous les produit du panier d' un client
     */
    @Query("select * from paniers where idClient = :idClient")
        fun recupTousPanier(idClient : Int): LiveData<List<PanierEntity>>

    /**
     * ajouter un produit au panier d'un client
     */
    @Insert
        suspend fun ajoutProdPanier(panier : PanierEntity)


}