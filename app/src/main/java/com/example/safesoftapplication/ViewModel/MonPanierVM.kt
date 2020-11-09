package com.example.safesoftapplication.ViewModel

//import androidx.hilt.Assisted
//import androidx.hilt.lifecycle.ViewModelInject
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.SavedStateHandle
//import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
//import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
//import com.example.safesoftapplication.repository.RepositoryMonCompte
//import com.example.safesoftapplication.repository.RepositoryPanier
//
//class MonPanierVM @ViewModelInject constructor(
//    val repositoryPanier: RepositoryPanier,
//    @Assisted savedStateHandle: SavedStateHandle
//)
//{
//    //passer la liste des produits du panier du client au fragment panier
//    var paniers : LiveData<List<PanierEntity>> = repositoryPanier.recupTousPanier()
//}