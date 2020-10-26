package com.example.safesoftapplication.backend.api.services

import com.example.safesoftapplication.backend.api.reponses.monCompteResponse.MonCompteResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

interface MonCompteServices {
    @GET("/client/recupClient")
        fun recupClient(
        @Field("idClient") idClient: Int
    ) : Flowable<MonCompteResponse>
}
