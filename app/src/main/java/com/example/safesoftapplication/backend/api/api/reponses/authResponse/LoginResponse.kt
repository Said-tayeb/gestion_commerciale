package com.example.safesoftapplication.backend.api.api.reponses.authResponse

import com.example.safesoftapplication.backend.api.api.reponses.Response
import java.util.*

class LoginResponse (
    val idClient: Int,
    val loginClient: String,
    val pswClient: String,
    val emailClient: String,
    val nomClient: String,
    val prenomClient: String,
    details: MutableList<String>
) : Response(details)
{

}