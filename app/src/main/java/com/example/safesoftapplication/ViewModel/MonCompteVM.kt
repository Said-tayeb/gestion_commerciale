package com.example.safesoftapplication.ViewModel

//import androidx.hilt.Assisted
//import androidx.hilt.lifecycle.ViewModelInject
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.SavedStateHandle
//import com.example.safesoftapplication.backend.api.api.repository.AuthRepository
//import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
//import com.example.safesoftapplication.repository.RepositoryAth
//import com.example.safesoftapplication.repository.RepositoryMonCompte
//
//class MonCompteVM @ViewModelInject constructor(
//    val repositoryMonCompte: RepositoryMonCompte,
//    @Assisted savedStateHandle: SavedStateHandle
//)
//{
//    //recuperer les informations des champs de fragment MonCompte
//    val loginClient : String = savedStateHandle["loginClient"] ?: throw IllegalArgumentException("missing user LoginClient")
//    val pswClient : String = savedStateHandle["pswClient"] ?: throw IllegalArgumentException("missing user pswClient")
//    val emailClient : String = savedStateHandle["emailClient"] ?: throw IllegalArgumentException("missing user emailClient")
//    val nomClient : String = savedStateHandle["nomClient"] ?: throw IllegalArgumentException("missing user nomClient")
//    val prenomClient : String = savedStateHandle["prenomClient"] ?: throw IllegalArgumentException("missing user prenomClient")
//
//    //passer les informations du client au fragment MonCompte
//    var client : LiveData<ClientEntity> = repositoryMonCompte.checkLogged()
//
//    //modifier les informations du client dans la base de donnees local et distante
//    suspend fun modifierClient(client : ClientEntity) = repositoryMonCompte.modifierClient(client)
//
//}