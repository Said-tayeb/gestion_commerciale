package com.example.safesoftapplication.ViewModel

//import androidx.hilt.Assisted
//import androidx.hilt.lifecycle.ViewModelInject
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.SavedStateHandle
//import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
//import com.example.safesoftapplication.model.Client
//import com.example.safesoftapplication.repository.RepositoryMonCompte
//import com.example.safesoftapplication.repository.repositoryInscription
//import java.util.*
//
//class InscriptionVM @ViewModelInject constructor(
//    val repositoryInscription: repositoryInscription,
//    @Assisted savedStateHandle: SavedStateHandle
//)
//{
//    //recuperer les valeurs des champs de l'activity inscription
//    val loginClient : String = savedStateHandle["loginClient"] ?: throw IllegalArgumentException("missing user LoginClient")
//    val pswClient : String = savedStateHandle["pswClient"] ?: throw IllegalArgumentException("missing user pswClient")
//    val confirmePswClient : String = savedStateHandle["confirmePswClient"] ?: throw IllegalArgumentException("missing user confirmePswClient")
//    val emailClient : String = savedStateHandle["emailClient"] ?: throw IllegalArgumentException("missing user emailClient")
//
//    //passer les informations du client a l'activity inscription
//    var client : LiveData<ClientEntity> = repositoryInscription.checkLogged()
//
//    /**
//     *inscrir et ajouter un client a la base de donnees distante et local
//     */
//    fun ajoutClient(client: ClientEntity) = repositoryInscription.ajoutClient(client)

//
//    fun creerClient(idClient : Int,
//                    loginClient : String,
//                    pswClient : String,
//                    nomClient : String,
//                    prenomClient : String,
//                    dateNaissance : Date,
//                    emailClient : String,
//                    adresseClient : String,
//                     codePostalClient : String) {
//        if (verifier()) {
//            val client = Client(
//                idClient,
//                loginClient,
//                pswClient,
//                nomClient,
//                prenomClient,
//                dateNaissance,
//                emailClient,
//                adresseClient,
//                codePostalClient
//            )
//            //        ajoute(client)
//        }else{
//
//        }
//
//    }
////    recupTousClient()
//    fun verifier() : Boolean {
//        if (true) {
//            //verification
//            //creerClient()
//            return true
//        } else {
//            return false
//        }
//    }
//}
