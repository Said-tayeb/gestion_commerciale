package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Catalogue(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID_PRODUIT") val id: Long,
    @ColumnInfo(name = "TITRE") val titre: String,
    @ColumnInfo(name = "PRIX") val prix: Int,
    @ColumnInfo(name = "DESCRIPTION") val description: String,
    @ColumnInfo(name = "CATEGORIE") val categorie: String,
    @ColumnInfo(name = "STOCK", defaultValue = "0") val stock: Double? = null,


    )