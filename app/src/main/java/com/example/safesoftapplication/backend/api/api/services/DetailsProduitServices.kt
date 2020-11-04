package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.detailsProduitResponse.DetailsProduitResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET

interface DetailsProduitServices {
        @GET("/produit/recupProduit")
        fun recupProduit(
            @Field("idProduit") idProduit : Int
        ) : Flowable<DetailsProduitResponse>
}