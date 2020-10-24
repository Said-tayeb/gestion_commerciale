package com.example.safesoftapplication.ui.authentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.model.Client
import com.example.safesoftapplication.backend.services.AuthServices
import com.example.safesoftapplication.ui.CatalogueClient.CatalogueActivity
import com.example.safesoftapplication.ui.inscription.InsriptionActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.*

class LoginActivity : AppCompatActivity() , AnkoLogger {

    //instance retrofit
    val url = "https://api.themoviedb.org/"
    val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /**
         * gestion d'evenement pour le bouton Inscription
         */

        btnInscription.setOnClickListener{
                longToast("Créer un compte")
            startActivity<InsriptionActivity>()
            //Création de l’instance du service
            val service = retrofit.create(AuthServices::class.java)
            //Création de la requêt GET
            val listClients = service.listClients()
            //Exécution de la requête
            listClients.enqueue(object: Callback<List<Client>> {
                override fun onResponse(call: Call<List<Client>>, response: Response<List<Client>>) {
                    val alllistClient = response.body()
                    alllistClient?.let {
                        for(client  in it) {
                            Log.d("Client","nom de client ${client.nomClient}")
                        }
                    }
                }
                override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                    Log.e("Client", "Error : $t")
                }
            })

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