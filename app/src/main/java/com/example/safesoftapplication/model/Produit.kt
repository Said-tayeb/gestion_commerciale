package com.example.safesoftapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Produit(
        val idProduit : Int,
        val titreProduit : String,
        val prixProduit : Float,
        val descriptionProduit : String,
        val categorieProduit : String,
        val stockProduit : Int,
        val imageProduit : String
){


}