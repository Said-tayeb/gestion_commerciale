package com.example.safesoftapplication.vM

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.repository.repositoryInscription

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
