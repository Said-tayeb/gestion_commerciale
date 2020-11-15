package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "produits")
data class ProduitEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idProduit") val idProduit: Int,
    @ColumnInfo(name = "titreProduit") val titreProduit: String,
    @ColumnInfo(name = "prixProduit") val prixProduit: Double,
    @ColumnInfo(name = "descriptionProduit") val descriptionProduit: String,
    @ColumnInfo(name = "categorieProduit") val categorieProduit: String,
    @ColumnInfo(name = "stockProduit", defaultValue = "0") val stockProduit: Double? = null
    )