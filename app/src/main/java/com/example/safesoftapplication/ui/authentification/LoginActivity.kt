package com.example.safesoftapplication.ui.authentification

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.safesoftapplication.R

import org.jetbrains.anko.AnkoLogger
import com.example.safesoftapplication.databinding.ActivityLoginBinding
import com.example.safesoftapplication.ui.inscription.InsriptionActivity
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() , AnkoLogger {
    private lateinit var binding: ActivityLoginBinding


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setLifecycleOwner(this)
        /**.recupToutClients()
         * gestion d'evenement pour le bouton Inscription
         */
//        binding.btnInscription.setOnClickListener{
//            val uri = Uri.parse("tel:0658164251")
//            val callIntent = Intent(Intent.ACTION_CALL, uri)
////            callIntent.data = Uri.parse("tel:0658164251")
//            if(ActivityCompat.checkSelfPermission(
//                    this,
//                    android.Manifest.permission.CALL_PHONE
//                ) != PackageManager.PERMISSION_GRANTED)
//            {
//                var permissions: Array<String>
//                permissions = arrayOf(android.Manifest.permission.CALL_PHONE)
//                requestPermissions(permissions, 1000)
//            }
//            startActivity(callIntent)
//        }

        /**!
         * Gestion d'évenement pour le bouton Valider
         */
//        binding.btnLogin.setOnClickListener {
////            var loginClient = binding.idLogin.text.toString()
//            var pswClient = binding.idPSW.text.toString()
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
    }
}