package com.example.safesoftapplication.model

import java.util.*

data class Commande(
        val idCommande : Int,
        val idClient : Int,
        val idProduit : Int,
        val dateCommande : Date,
        val dateExpCommande : Date,
        val quantiteProduit : Int,
        val prixTotal : Float
){

}