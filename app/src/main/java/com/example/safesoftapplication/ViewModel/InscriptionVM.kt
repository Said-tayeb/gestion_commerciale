package com.example.safesoftapplication.ViewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.model.Client
import com.example.safesoftapplication.repository.RepositoryMonCompte
import com.example.safesoftapplication.repository.repositoryInscription
import java.util.*

class InscriptionVM @ViewModelInject constructor(
    val repositoryInscription: repositoryInscription
//    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel()
{

    var essai = "dddddddddd"

    //passer les informations du client a l'activity inscription
//    val client : LiveData<ClientEntity> = TODO()

    /**
     *inscrir et ajouter un client a la base de donnees distante et local
     */
    fun ajoutClient(client: ClientEntity) : Boolean {
        repositoryInscription.ajoutClient(client)
        return true
    }
}
