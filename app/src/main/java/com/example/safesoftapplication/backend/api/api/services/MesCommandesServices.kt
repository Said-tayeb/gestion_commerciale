package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.mesCommandesResponse.MesCommandesResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET

interface MesCommandesServices {
    @GET("/commande/recupCommandesClient")
        fun recupToutesCommandes(
        @Field("idClient") idClient : Int
    ) : Flowable<List<MesCommandesResponse>>
}