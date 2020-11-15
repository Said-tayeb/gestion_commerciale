package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse.produitsResponse
import io.reactivex.Flowable
import retrofit2.http.GET


interface CatalogueService {

    @GET("api/produit/recupToutProduits.php")
        fun recupToutProduits() : Flowable<List<produitsResponse>>
}