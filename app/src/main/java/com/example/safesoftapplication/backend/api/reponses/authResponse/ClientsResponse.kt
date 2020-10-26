package com.example.safesoftapplication.backend.api.reponses.authResponse

import java.util.*

class ClientsResponse(
    val idClient : Int,
    val loginClient : String,
    val pswClient : String,
    val nomClient : String,
    val prenomClient : String,
    val dateNaissance : Date,
    val emailClient : String,
    val adresseClient : String,
    val codePostalClient : Int
)