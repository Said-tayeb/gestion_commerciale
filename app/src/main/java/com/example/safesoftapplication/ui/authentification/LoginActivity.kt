package com.example.safesoftapplication.ui.authentification

import androidx.appcompat.app.AppCompatActivity

import org.jetbrains.anko.AnkoLogger
import com.example.safesoftapplication.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() , AnkoLogger {
//    private lateinit var binding: ActivityLoginBinding
//    private val viewModel: AuthentifivationVM by viewModels()
//
////        factoryProducer = { SavedStateVMFactory(this) })
//
////    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
////        SavedStateViewModelFactory(application, this, intent?.extras ?: Bundle())
////    val model = ViewModelProviders.of(this).get(AuthentifivationVM::class.java)
////    private lateinit var loginClient : String
////    private lateinit var pswClient : String
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
////        val model = ViewModelProviders.of(this, SavedStateViewModelFactory(getApplication(), this)).get(AuthentifivationVM::class.java)
//        binding.setLifecycleOwner(this)
//        /**.recupToutClients()
//         * gestion d'evenement pour le bouton Inscription
//         */
//        binding.btnInscription.setOnClickListener{
//            longToast("Créer un compte")
//            startActivity < InsriptionActivity >()
//        }
//
//        /**!
//         * Gestion d'évenement pour le bouton Valider
//         */
//        binding.btnLogin.setOnClickListener {
////            var loginClient = binding.idLogin.text.toString()
////            var pswClient = binding.idPSW.text.toString()
//            viewModel.essaif()
//            Log.d("viewModel", "_____")
//            longToast("clic")
//            if (viewModel.verifierLogin()){
//                longToast("vous devez remplir tous les champs")
//            }else{
//                if (viewModel.recupClient().value == null){
//                    longToast("erreur d'authentification")
//                }else{
//                    longToast("Bonjour")
//                    startActivity<AccueilActivity>()
//                }
//            }
//        }
//    }
}