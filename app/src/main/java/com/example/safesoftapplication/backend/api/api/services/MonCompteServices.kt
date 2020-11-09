package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientResponse
import com.example.safesoftapplication.backend.api.api.reponses.monCompteResponse.MonCompteResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PUT

interface MonCompteServices {

    /**
     * recuperer les informations d'un client
     */
    @GET("/client/recupClient")
        fun recupClient(
        @Field("idClient") idClient: Int
    ) : Flowable<MonCompteResponse>

    /**
     * modifier un compte d'un client
     */
    @FormUrlEncoded
    @PUT("/client/modifierClient.php")
    fun modifierClient(
        @Field("loginClient") loginClient: String,
        @Field("pswClient") pswClient: String,
        @Field("emailClient") emailClient: String,
        @Field("nomClient") nomClient: String,
        @Field("PrenomClient") prenomClient: String
    ): Flowable<ClientResponse>

}
