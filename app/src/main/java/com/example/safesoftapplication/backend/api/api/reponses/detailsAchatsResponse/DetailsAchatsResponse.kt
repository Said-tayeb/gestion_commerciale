package com.example.safesoftapplication.backend.api.api.reponses.detailsAchatsResponse

import java.util.*

class DetailsAchatsResponse (
    val idCommande : Int,
    val idClient : Int,
    val idProduit : Int,
    val dateCommande : Date,
    val dateExpCommande : Date,
    val quantiteProduit : Int,
    val prixTotal : Float

)