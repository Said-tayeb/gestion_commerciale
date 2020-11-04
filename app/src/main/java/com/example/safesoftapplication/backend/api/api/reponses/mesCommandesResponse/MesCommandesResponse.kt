package com.example.safesoftapplication.backend.api.api.reponses.mesCommandesResponse

import java.util.*

class MesCommandesResponse (
    val idCommande : Int,
    val idClient : Int,
    val idProduit : Int,
    val dateCommande : Date,
    val dateExpCommande : Date,
    val quantiteProduit : Int,
    val prixTotal : Float
)