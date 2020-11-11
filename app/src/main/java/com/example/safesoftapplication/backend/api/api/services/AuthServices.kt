package com.example.safesoftapplication.backend.api.api.services
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientResponse
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.LoginResponse
import com.example.safesoftapplication.backend.api.api.reponses.inscriptionResponse.InscriptionResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*


interface AuthServices {

    //recuperer un client
    @FormUrlEncoded
    @GET("/client/recupClientLogin.php")
   fun recupClientLogin(
        @Field("loginClient") loginClient : String,
        @Field("pswClient") pswClient : String
    ): Flowable<ClientResponse>

    //recuperer tous les clients
    @FormUrlEncoded
    @GET("/client/recupToutClients.php")
    fun recupToutClients() : Flowable<List<ClientsResponse>>

    //authentifier
    @FormUrlEncoded
    @POST("/client/login.php")
    fun login(
        @Field("loginClient") loginClient: String,
        @Field("pswClient") pswClient: String
    ): Flowable<LoginResponse>

    //modifier un client
    @FormUrlEncoded
    @PUT("/client/modifierClient.php")
    fun modifierClient(
        @Field("loginClient") loginClient: String,
        @Field("pswClient") pswClient: String,
        @Field("emailClient") emailClient: String,
        @Field("nomClient") nomClient: String,
        @Field("PrenomClient") prenomClient: String
    ): Flowable<ClientResponse>

    //ajouter un client
    @FormUrlEncoded
    @POST("/client/ajoutClient.php")
    fun ajoutClient(
        //@Body loginClient : String
        @Field("loginClient") loginClient : String,
        @Field("pswClient") pswClient : String,
        @Field("emailClient") emailClient : String,
        @Field("nomClient") nomClient : String,
        @Field("prenomClient") prenomClient : String
    ): Flowable<ClientResponse>

}