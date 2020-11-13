package com.example.safesoftapplication.ui.inscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.safesoftapplication.AccueilActivity
import com.example.safesoftapplication.R
import com.example.safesoftapplication.vM.InscriptionVM
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.databinding.ActivityInsriptionBinding
import com.example.safesoftapplication.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.android.synthetic.main.fragment_blank.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity

@AndroidEntryPoint
class InsriptionActivity : AppCompatActivity(), AnkoLogger {
    private val BASE_URL = "http://192.168.43.165/api/"
    private lateinit var binding: ActivityInsriptionBinding
    private val viewModel: InscriptionVM by viewModels()
//    val inscriptionServices by lazy {
//        AppelRetrofit.getClient(BASE_URL)?.create(InscriptionServices::class.java)
//    }
//    var disposable: Disposable? = null
//    private var myCompositeDisposable: CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_insription)

        /**
         * gestion d'évenement pour le bouton
         */
        binding.btnEnregistrer.setOnClickListener{
            even()
        }
    }

    /**
     * gestion d'evenement pour le bouton inscription
     */
    fun even(){
        var loginClient = binding.editTextLoginInscription.text.toString()
        var pswClient = binding.editTextPasswordInscription.text.toString()
        var cPswClient = binding.editTextConfirmePassword.text.toString()
        var emailClient = binding.editTextEmail.text.toString()
        var nomClient = binding.editTextNomonCompte.text.toString()
        var prenomClient = binding.editTextPrenom.text.toString()
        if (loginClient == "" || pswClient == "" || cPswClient == "" || emailClient == "" || nomClient == "" || prenomClient == ""){
            longToast("vous devez remplir tous les champs")
        }else{
            if (cPswClient == pswClient){
                var clientEntity = ClientEntity(1,loginClient, pswClient, emailClient, nomClient, prenomClient, 1 )
                Log.d("viewModel", "=========" + viewModel.essai)
                if (true){
                    longToast("Vous avez bien inscrit")
                    startActivity<AccueilActivity>()
                }else{
                    longToast("utilisateur déja exitant")
                }
            }else{
                longToast("verifier votre mot de passe")
            }
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

//    override fun onPause() {
//        super.onPause()
//        disposable?.dispose()
//    }
}