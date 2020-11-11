package com.example.safesoftapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.repository.RepositoryAth
import com.example.safesoftapplication.repository.RepositoryMonCompte
//
//class MonCompteViewModel@ViewModelInject constructor(
//   // val repositoryMonCompte: RepositoryMonCompte
////     @Assisted savedStateHandle: SavedStateHandle
//)  : ViewModel() {
//
////    lateinit var loginClient : String
////    //passer les donnees au fragment
////    val client : LiveData<ClientEntity> = repositoryMonCompte.recupClientByLogin(loginClient)
//
//
//}