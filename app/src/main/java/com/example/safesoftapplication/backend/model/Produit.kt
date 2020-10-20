package com.example.safesoftapplication.backend.model

data class Produit(
        val idProduit : Int,
        val titreProduit : String,
        val prixProduit : Float,
        val descriptionProduit : String,
        val categorieProduit : String,
        val stockProduit : Int
){

}