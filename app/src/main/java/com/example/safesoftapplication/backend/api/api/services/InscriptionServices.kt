package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.api.reponses.inscriptionResponse.InscriptionResponse
import io.reactivex.Observable
import retrofit2.http.*

interface InscriptionServices {

    //ajouter un utilisateur
//    @Headers("Content-Type: application/json;charset=utf-8")
    @Multipart
    @POST("/client/ajoutClient.php")
    fun ajoutClient(
        //@Body loginClient : String
        @Field("loginClient") loginClient : String,
        @Field("pswClient") pswClient : String,
        @Field("nomClient") nomClient : String,
        @Field("prenomClient") prenomClient : String,
        //@Field("dateNaissanceClient") dateNaissanceClient: Date,
        @Field("emailClient") emailClient : String,
        @Field("adresseClient") adresseClient : String,
        @Field("codePostalClient") codePostalClient : Int
        ): Observable<InscriptionResponse>

    //recuperer tous les clients
    @GET("client/recupToutClients.php")
    fun recupToutClients() : Observable<List<ClientsResponse>>

}