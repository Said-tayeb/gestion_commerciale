package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity

@Dao
interface PanierDao {

    /**
     * recuperer tous les produit du panier du client
     */
    @Query("select * from paniers")
    fun recupTousPanier(): LiveData<List<PanierEntity>>
}