package com.example.safesoftapplication.ViewModel

import com.example.safesoftapplication.model.Client
import java.util.*

class InscriptionVM {

    fun creerClient(idClient : Int,
                    loginClient : String,
                    pswClient : String,
                    nomClient : String,
                    prenomClient : String,
                    dateNaissance : Date,
                    emailClient : String,
                    adresseClient : String,
                     codePostalClient : String) {
        if (verifier()) {
            val client = Client(
                idClient,
                loginClient,
                pswClient,
                nomClient,
                prenomClient,
                dateNaissance,
                emailClient,
                adresseClient,
                codePostalClient
            )
            //        ajoute(client)
        }else{

        }

    }
//    recupTousClient()
    fun verifier() : Boolean {
        if (true) {
            //verification
            //creerClient()
            return true
        } else {
            return false
        }
    }
}
