package com.example.safesoftapplication.ui.authentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.safesoftapplication.AccueilActivity

import com.example.safesoftapplication.R
import com.example.safesoftapplication.ViewModel.AuthentifivationVM
import com.example.safesoftapplication.backend.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.services.AuthServices
import com.example.safesoftapplication.ui.inscription.InsriptionActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory.*

class LoginActivity : AppCompatActivity() , AnkoLogger {

    //declarer les variables
    private val BASE_URL = "http://192.168.43.165/api/"
    private var myCompositeDisposable: CompositeDisposable? = null
    private lateinit var loginClient : String
    private lateinit var pswClient : String
    private lateinit var listClients : List<ClientsResponse>
    var connexion = false
    var j=0
    private lateinit var authentifivationVM : AuthentifivationVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        myCompositeDisposable = CompositeDisposable()
        loadData()

        /**.recupToutClients()
         * gestion d'evenement pour le bouton Inscription
         */
        btnInscription.setOnClickListener{
            longToast("Créer un compte")
            startActivity < InsriptionActivity >()
        }


        /**
         * Gestion d'évenement pour le bouton Valider
         */
        btnLogin.setOnClickListener{
            if (connexion){
                loginClient = idLogin.text.toString()
                pswClient = idPSW.text.toString()
                Log.d("login", "_______" + loginClient + "______" + pswClient)

                if (verifier(listClients, loginClient, pswClient)){
                    longToast("Bonjour")
                    startActivity<AccueilActivity>()
                }else{
                    longToast("erreur d'authentification")

                }
            }else{
                longToast("Aucune connexion")
            }

        }

    }

    /**
     * recuperation des donnees dans la base de données distante
     */
    fun loadData(){
        //creation de l'instance retrofit
            val authService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //Obtenez un objet Retrofit utilisable en appelant .build ()
                .build().create(AuthServices::class.java)

        // Appeler l'API à l'aide de RxJava & RxAndroid
                 myCompositeDisposable?.add(authService.recupToutClients()
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribeOn(Schedulers.io())
                     .subscribe(this::handleResponse, this :: handleError))
    }

    /**
     * gerer la reponse de rxjava observable
     */
    private fun handleResponse(Clients: List<ClientsResponse>) {
        longToast("connecter")
        connexion = true
        Log.d("login", "connecter")
        listClients = Clients
    }

    /**
     * gerer l'erreur
     */
    fun handleError (error: Throwable) {
        longToast("l'apparail n'est pas connecter au serveur")
        Log.d("login", "erreur")

    }

    /**
     * effacer le CompositeDisposable
     */
    override fun onDestroy() {
        super.onDestroy()
        myCompositeDisposable?.clear()
    }

    fun verifier(listClients : List<ClientsResponse>, loginClient : String, pswClient : String):Boolean{
        var bool = false
        j=0
        while (!bool and(j < listClients.size)){
            if ((listClients.get(j).loginClient == loginClient) and(listClients.get(j).pswClient == pswClient) ){
                Log.d("login","trouvé")
                bool = true
                return bool
            }
            j++
        }
        return bool
    }
}