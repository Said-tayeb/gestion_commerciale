package com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse

import com.google.gson.annotations.SerializedName

data class produitsResponse(
    @SerializedName("idProduit")
    val idProduit: Int,
    @SerializedName("titreProduit")
    val titreProduit: String,
    @SerializedName("prixProduit")
    val prixProduit: Float,
    @SerializedName("descriptionProduit")
    val descriptionProduit: String,
    @SerializedName("categorieProduit")
    val categorieProduit: String,
    @SerializedName("stockProduit")
    val stockProduit: Int,
    @SerializedName("imageProduit")
    val imageProduit: String
)