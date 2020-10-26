package com.example.safesoftapplication.backend.api.services

import com.example.safesoftapplication.backend.api.reponses.detailsAchatsResponse.DetailsAchatsResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsAchatsServices {
    @GET("/commandes/")
        fun recupCommande(
        @Field("idCommande") idCommande : Int
    ):Flowable<DetailsAchatsResponse>
}