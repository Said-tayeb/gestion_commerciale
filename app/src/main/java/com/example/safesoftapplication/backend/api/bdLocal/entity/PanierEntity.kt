package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "paniers")
data class PanierEntity(
    @PrimaryKey(autoGenerate = true) val idPanier: Int,
    @ColumnInfo(name = "idClient") val idClient : Int,
    @ColumnInfo(name = "idProduit") val idProduit : Int,
    @ColumnInfo(name = "prixProduit") val prixProduit: Double,
    @ColumnInfo(name = "imageProduit") val imageProduit: String
)