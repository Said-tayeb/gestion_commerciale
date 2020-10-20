package com.example.safesoftapplication.ui.authentification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.safesoftapplication.R
import com.example.safesoftapplication.ui.CatalogueClient.CatalogueActivity
import com.example.safesoftapplication.ui.inscription.InsriptionActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() , AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /**
         * gestion d'evenement pour le bouton Inscription
         */
        btnInscription.setOnClickListener{
                longToast("Créer un compte")
            startActivity<InsriptionActivity>()

        }

        /**
         * Gestion d'évenement pour le bouton Valider
         */
        btnLogin.setOnClickListener{
            if (true){
                longToast("Bonjour")
                startActivity<CatalogueActivity>()
            }else{
                longToast("erreur d'authentification")
            }
        }

    }

}