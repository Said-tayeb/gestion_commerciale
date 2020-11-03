package com.example.safesoftapplication.ui.inscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.safesoftapplication.R
import com.example.safesoftapplication.ui.authentification.LoginActivity
import kotlinx.android.synthetic.main.activity_insription.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import java.util.*

class InsriptionActivity : AppCompatActivity(), AnkoLogger {
    private lateinit var loginClient : String
    private lateinit var pswClient : String
    private lateinit var nomClient : String
    private lateinit var prenomClient : String
    private lateinit var dateNaissanceClient : String
    private lateinit var emailClient : String
    private lateinit var adresseClient : String
    private lateinit var codePostalClient : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insription)

        /**
         * gestion d'évenement pour le bouton
         */
        btnEnregistrer.setOnClickListener{
            //recuperation des données
            loginClient = editTextLoginInscription.toString()
            pswClient = editTextPasswordInscription.toString()
            nomClient = editTextNomonCompte.toString()
            prenomClient = editTextPrenom.toString()
            dateNaissanceClient = editTextDateNaissance.toString()
            emailClient = editTextEmail.toString()
            adresseClient = editTextAdresse.toString()
            codePostalClient = editTextCodePostal.toString()
            longToast("Vous avez bien inscrit")
            startActivity<LoginActivity>()
//            if (InscriptionVM.verifier(
//                    loginClient,  pswClient,  nomClient,  prenomClient,  dateNaissance,  emailClient,  adresseClient,  codePostalClient)){
//                longToast("Vous avez bien inscrit")
//                startActivity<CatalogueActivity>()
//            }else{
//                longToast("Ce compte éxite déjà")
//            }

        }
    }


}