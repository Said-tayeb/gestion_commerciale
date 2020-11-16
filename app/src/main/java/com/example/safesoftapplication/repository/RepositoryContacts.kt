package com.example.safesoftapplication.repository

import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.backend.api.api.services.ContactServices
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.InfosOrganismeDao
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepositoryContacts @Inject constructor(
    private val infosOrganismeDao: InfosOrganismeDao
//    private val contactServices: ContactServices
)
{

    /**
     * recuperer les informations de l'organisme
     */
    suspend fun recupInfosOrganisme() = infosOrganismeDao.recupInfosOrganisme()

//    fun recupInfosOrganismeServeur() = contactServices.recupInfosOrganisme()



}