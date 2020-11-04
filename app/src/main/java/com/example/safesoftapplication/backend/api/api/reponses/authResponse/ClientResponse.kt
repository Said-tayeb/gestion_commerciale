package com.example.safesoftapplication.backend.api.api.reponses.authResponse

import com.example.safesoftapplication.backend.api.api.reponses.Response
import java.util.*

class ClientResponse(
    val idClient : Int,
    val loginClient : String,
    val pswClient : String,
    val nomClient : String,
    val prenomClient : String,
    val dateNaissance : Date,
    val emailClient : String,
    val adresseClient : String,
    val codePostalClient : Int,
    details: MutableList<String>
): Response(details)