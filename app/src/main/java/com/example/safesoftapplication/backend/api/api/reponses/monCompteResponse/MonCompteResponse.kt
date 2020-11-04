package com.example.safesoftapplication.backend.api.api.reponses.monCompteResponse

import java.util.*

class MonCompteResponse (
    val idClient : Int,
    val loginClient : String,
    val pswClient : String,
    val nomClient : String,
    val prenomClient : String,
    val dateNaissance : Date,
    val emailClient : String,
    val adresseClient : String,
    val codePostalClient : String
)