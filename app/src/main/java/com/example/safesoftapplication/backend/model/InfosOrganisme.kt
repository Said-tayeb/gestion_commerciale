package com.example.safesoftapplication.backend.model

data class InfosOrganisme(
        val nomOrganisme : String,
        val email1Organisme: String,
        val email2Organisme : String?,
        val telephone1Organisme : Int,
        val telephone2Organisme : Int?,
        val adresseOrganisme : String,
        val codePostalOrganisme : String
){

}