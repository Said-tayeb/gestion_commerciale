package com.example.safesoftapplication.backend.api.reponses.detailsProduitResponse

class DetailsProduitResponse (
    val idProduit : Int,
    val titreProduit : String,
    val prixProduit : Float,
    val descriptionProduit : String,
    val categorieProduit : String,
    val stockProduit : Int
)