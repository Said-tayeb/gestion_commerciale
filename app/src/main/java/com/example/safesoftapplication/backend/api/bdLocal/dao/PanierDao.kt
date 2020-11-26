package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
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
     * recuperer un liveData produit du panier d' un client
     */
    @Query("select * from paniers where idClient = :idClient and idProduit = :idProduit limit 1")
        fun recupProduitPanier(idProduit : Int, idClient : Int): LiveData<PanierEntity>

    /**
     * recuperer un produit du panier d' un client
     */
    @Query("select * from paniers where idClient = :idClient and idProduit = :idProduit limit 1")
        suspend fun recupProduitEntPanier(idProduit : Int, idClient : Int): PanierEntity?

    /**
     * supprimer un produit du panier d' un client
     */
    @Query("delete from paniers where idProduit = :idProduit")
        suspend fun supProduitPanierById(idProduit : Int)

    @Query("delete from paniers where idClient = :idClient")
        suspend fun supToutPanier(idClient : Int)

    /**
     * ajouter un produit au panier d'un client
     */
    @Insert
        suspend fun ajoutProdPanier(panier : PanierEntity)

    /**
     * supprimer un produit au panier d'un client
     */
    @Delete
        suspend fun supProduitPanier(panier : PanierEntity)


}