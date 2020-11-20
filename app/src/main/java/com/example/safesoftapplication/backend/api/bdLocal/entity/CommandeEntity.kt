package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "commandes", indices = [Index(value = ["idCommande"], unique = true)])
data class CommandeEntity (
    @PrimaryKey(autoGenerate = true) val idCommande: Int,
    @ColumnInfo(name = "idClient") val idClient : Int,
    @ColumnInfo(name = "idProduit") val idProduit : Int,
    @ColumnInfo(name = "dateCommande") val dateCommande : Long,
    @ColumnInfo(name = "dateExpCommande") val dateExpCommande : Long,
    @ColumnInfo(name = "quantiteProduit") val quantiteProduit : Int,
    @ColumnInfo(name = "prixTotalCommande") val prixTotalCommande : Int,
)