package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity


@Dao
interface CatalogueDao {

    @Transaction
    @Query("SELECT * FROM produits")
    fun getAllProduits(): LiveData<List<ProduitEntity>>

}