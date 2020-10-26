package com.example.safesoftapplication.model

import java.util.*

data class Client(
       val idClient : Int,
       val loginClient : String,
       val pswClient : String,
       val nomClient : String,
       val prenomClient : String,
       val dateNaissance : Date,
       val emailClient : String,
       val adresseClient : String,
       val codePostalClient : Int
){

}