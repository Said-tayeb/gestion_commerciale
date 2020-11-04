package com.example.safesoftapplication.backend.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppelRetrofit {
    companion object {
        var retrofit : Retrofit? = null
        fun  getClient(baseUrl : String) : Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //Obtenez un objet Retrofit utilisable en appelant .build ()
                    .build()
                Log.d("login", "retrofit create")
            }
            return retrofit
    }
}
}

