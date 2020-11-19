package com.example.safesoftapplication.model

import java.util.*

data class Client(
    var idClient: Int,
    var loginClient: String,
    var pswClient: String,
    var emailClient: String,
    var nomClient: String,
    var prenomClient: String
){

}