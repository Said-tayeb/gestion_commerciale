package com.example.safesoftapplication.backend.api.services

import com.example.safesoftapplication.backend.api.reponses.inscriptionResponse.InscriptionResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.POST

interface InscriptionServices {
    @POST("api/clients")
    fun ajoutClient(
        @Field("login") login : String,
        @Field("psw") psw : String,
        @Field("nom") nom : String,
        @Field("prenom") prenom : String,
        @Field("dateNaissanceClient") dateNaissanceClient: String,
        @Field("email") email : String,
        @Field("adresse") adresse : String,
        @Field("codePostal") codePostal : String
    ): Flowable<InscriptionResponse>
}