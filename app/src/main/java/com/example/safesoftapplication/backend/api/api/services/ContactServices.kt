package com.example.safesoftapplication.backend.api.api.services

import com.example.safesoftapplication.backend.api.api.reponses.contact.InfosOrganismeResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ContactServices {
    @GET("/api/infoOrganisme/recupInfosOrganisme")
        fun recupInfosOrganisme() : Flowable<InfosOrganismeResponse>
}