package com.example.safesoftapplication.backend.services

import com.example.safesoftapplication.backend.model.Client
import retrofit2.Call
import retrofit2.http.GET


interface AuthServices {
    //recuperer tous les clients
    @GET("/client")
   fun listClients(): Call<List<Client>>
}