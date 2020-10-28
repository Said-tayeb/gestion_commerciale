package com.example.safesoftapplication.backend.api.services
import com.example.safesoftapplication.backend.api.reponses.authResponse.ClientResponse
import com.example.safesoftapplication.backend.api.reponses.authResponse.ClientsResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET


interface AuthServices {
    //recuperer un client
    @GET("/client/recupClient")
   fun recupClient(
        @Field("idClient") idClient : Int
    ): Observable<ClientResponse>
    @GET("client/recupToutClients.php")
    fun recupToutClients() : Observable<List<ClientsResponse>>

}