package com.example.safesoftapplication.backend.api.api.services
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientResponse
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.LoginResponse
import io.reactivex.Flowable
import retrofit2.http.*


interface AuthServices {

    //authentifier
    @POST("/client/login.php")
    fun login(
        @Field("loginClient") loginClient: String,
        @Field("pswClient") pswClient: String
    ): Flowable<LoginResponse>

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

    //modifier un client
    @PUT("/client/modifierClient.php")
    fun modifierClient(
        @Field("loginClient") loginClient: String,
        @Field("emailClient") emailClient: String,
//        @Field("password") password: String,
        @Field("nomClient") nomClient: String,
        @Field("PrenomClient") prenomClient: String
    ): Flowable<ClientResponse>

}