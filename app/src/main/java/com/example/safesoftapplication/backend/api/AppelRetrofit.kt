package com.example.safesoftapplication.backend.api

import android.content.Context
import com.example.safesoftapplication.backend.api.services.AuthServices
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppelRetrofit (
    //creation de l'instance de modernisation


){
    private val BASE_URL="http://192.168.43.165/api/"
    private val instanceRetrofit : Retrofit? = null
    public fun getRetrofit() : Retrofit? {
        if (instanceRetrofit == null){
            val instanceRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //Obtenez un objet Retrofit utilisable en appelant .build ()
                .build()

        }
        return instanceRetrofit

    }

}

