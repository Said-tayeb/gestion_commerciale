package com.example.safesoftapplication.backend.api.services

import com.example.safesoftapplication.backend.api.reponses.panierResponse.PanierResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

interface MonPanierServices {
    //recuperer les produit d'un panier
    @GET("/panier/recupProduitsPanier")
        fun recupPanier(
        @Field("idClient") idClient : Int
    ) : Flowable<PanierResponse>
}