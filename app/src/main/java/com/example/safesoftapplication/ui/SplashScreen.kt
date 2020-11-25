package com.example.safesoftapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.safesoftapplication.AccueilActivity
import com.example.safesoftapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.AnkoLogger

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


//        val cour = GlobalScope.launch {
//            delay(5000)
////            finishAffinity()
//        }
        lifecycleScope.launch {
            Log.d("TAG", "onCreate: inside the scope")
            delay(3000)
            Log.d("TAG", "onCreate: after delay")
            startActivity(Intent(applicationContext, AccueilActivity::class.java))
            finish()
        }
    }
}