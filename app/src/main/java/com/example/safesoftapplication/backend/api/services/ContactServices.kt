package com.example.safesoftapplication.backend.api.services

import com.example.safesoftapplication.backend.api.reponses.contact.InfosOrganismeResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ContactServices {
    @GET("/api/infoOrganisme/recupInfosOrganisme")
        fun infosOrganisme() : Flowable<InfosOrganismeResponse>
}