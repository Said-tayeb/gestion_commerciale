package com.example.safesoftapplication.ui.inscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.safesoftapplication.R
import com.example.safesoftapplication.ui.CatalogueClient.CatalogueActivity
import kotlinx.android.synthetic.main.activity_insription.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import java.util.*

class InsriptionActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insription)

        /**
         * gestion d'évenement pour le bouton
         */
        btnEnregistrer.setOnClickListener{
            //recuperation des données
            var loginClient = editTextLoginInscription.toString()
            var pswClient = editTextPasswordInscription.toString()
            var nomClient = editTextNomonCompte.toString()
            var prenomClient = editTextPrenom.toString()
            var dateNaissance : Date
            //dateNaissance = Date.from(editTextDateNaissance)
            var emailClient = editTextEmail.toString()
            var adresseClient = editTextAdresse.toString()
            var codePostalClient = editTextCodePostal.toString()
            longToast("Vous avez bien inscrit")
                startActivity<CatalogueActivity>()
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