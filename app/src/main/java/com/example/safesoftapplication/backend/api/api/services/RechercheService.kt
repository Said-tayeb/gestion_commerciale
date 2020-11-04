package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.rechercheResponse.RechercheResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.GET

interface RechercheService {
    @GET("/produit/rechercheProduits")
        fun rechercheProduit(@Field("motCle") motCle : String) : Flowable<List<RechercheResponse>>
}