package com.example.safesoftapplication.ui.authentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.safesoftapplication.AccueilActivity

import com.example.safesoftapplication.R
import com.example.safesoftapplication.ViewModel.AuthentifivationVM
import com.example.safesoftapplication.backend.api.AppelRetrofit
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.model.Client
import com.example.safesoftapplication.ui.inscription.InsriptionActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import com.example.safesoftapplication.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() , AnkoLogger {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AuthentifivationVM by viewModels()
//        factoryProducer = { SavedStateVMFactory(this) })

//    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
//        SavedStateViewModelFactory(application, this, intent?.extras ?: Bundle())
//    val model = ViewModelProviders.of(this).get(AuthentifivationVM::class.java)
//private val viewModel: AuthentifivationVM by viewModels()
// lateinit var c : LiveData<Client>
//    private lateinit var loginClient : String
//    private lateinit var pswClient : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//    val model = ViewModelProviders.of(this, SavedStateViewModelFactory(getApplication(), this)).get(AuthentifivationVM::class.java)
       // myCompositeDisposable = CompositeDisposable()
        //loadData()

        /**.recupToutClients()
         * gestion d'evenement pour le bouton Inscription
         */
        binding.btnInscription.setOnClickListener{
            longToast("Créer un compte")
            startActivity < InsriptionActivity >()
        }

        /**!
         * Gestion d'évenement pour le bouton Valider
         */
        binding.btnLogin.setOnClickListener {
            viewModel.init()
//            longToast("clic bouton login")
//            //longToast(""+viewModel.recupClient())
//            if (viewModel.recupClient().value?.loginClient == "said"){
//                longToast("erreur d'authentification")
//            }else{
//                longToast("Bonjour")
//                startActivity<AccueilActivity>()
//           }
        }

    }

}