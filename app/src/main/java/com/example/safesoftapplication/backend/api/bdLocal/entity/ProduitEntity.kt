package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class ProduitEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID_PRODUIT") val id: Long,
    @ColumnInfo(name = "TITRE_PRODUIT") val titreProduit: String,
    @ColumnInfo(name = "PRIX_PRODUIT") val prixProdut: Int,
    @ColumnInfo(name = "DESCRIPTION_PRODUIT") val descriptionProdut: String,
    @ColumnInfo(name = "CATEGOR_IEPRODUIT") val categorieProdut: String,
    @ColumnInfo(name = "STOCK_PRODUIT", defaultValue = "0") val stockProdut: Double? = null,
    )