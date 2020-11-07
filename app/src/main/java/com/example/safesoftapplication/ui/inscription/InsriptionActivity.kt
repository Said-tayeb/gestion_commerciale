package com.example.safesoftapplication.ui.inscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.AppelRetrofit
import com.example.safesoftapplication.backend.api.bdLocal.DateConverter
import com.example.safesoftapplication.backend.api.api.services.InscriptionServices
import com.example.safesoftapplication.model.Client
import com.example.safesoftapplication.ui.authentification.LoginActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_insription.*
//import kotlinx.android.synthetic.main.fragment_blank.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import java.util.*

class InsriptionActivity : AppCompatActivity(), AnkoLogger {
    private val BASE_URL = "http://192.168.43.165/api/"
    val inscriptionServices by lazy {
        AppelRetrofit.getClient(BASE_URL)?.create(InscriptionServices::class.java)
    }
    var disposable: Disposable? = null
//    private var myCompositeDisposable: CompositeDisposable? = null
    private lateinit var dateConverter : DateConverter
    private lateinit var loginClient : String
    private lateinit var pswClient : String
    private lateinit var nomClient : String
    private lateinit var prenomClient : String
    private lateinit var dateNaissanceClient : Date
    private lateinit var emailClient : String
    private lateinit var adresseClient : String
    private var codePostalClient : Int = 0
    var connexion = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insription)

        /**
         * gestion d'évenement pour le bouton
         */
        btnEnregistrer.setOnClickListener{
            //recuperation des données
            dateConverter = DateConverter()
            loginClient = editTextLoginInscription.toString()
            pswClient = editTextPasswordInscription.toString()
            nomClient = editTextNomonCompte.toString()
            prenomClient = editTextPrenom.toString()
            dateNaissanceClient = dateConverter.stringToDate((editTextDateNaissance.toString()), "aa-bb-yyyy")!!
            emailClient = editTextEmail.toString()
            adresseClient = editTextAdresse.toString()
            codePostalClient = Integer.parseInt(editTextCodePostal.toString())
//            ajoutClient()
            var client = Client(1, loginClient, pswClient,emailClient, nomClient, prenomClient)
            longToast("Vous avez bien inscrit")
            startActivity<LoginActivity>()
//            if (InscriptionVM.verifier( client )){
//                longToast("Vous avez bien inscrit")
//                startActivity<AccueilActivity>()
//            }else{
//                longToast("Ce compte éxite déjà")
//            }

        }
    }

//    fun ajoutClient(){
//        disposable = inscriptionServices?.ajoutClient(loginClient, pswClient, nomClient, prenomClient, emailClient,
//            adresseClient, codePostalClient)
//            ?.subscribeOn(Schedulers.io())
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.subscribe(
//                { result ->
//                    longToast("succee d'ajout")
//                    Log.v("inscription", "_______succee" ) },
//                { error ->
//                    longToast("echeck d'ajout")
//                    Log.e("inscription", "________"+error.message.toString()) }
//            )
//    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}