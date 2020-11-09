package com.example.safesoftapplication.backend.api.api.repository

//import javax.inject.Inject
//import javax.inject.Named
//import com.example.safesoftapplication.backend.api.api.services.AuthServices
//
//class AuthRepository @Inject constructor(
//    @Named("non_auth_auth_service") private val unauthorizedService: AuthServices,
//    @Named("auth_auth_service") private val authorizedService: AuthServices
//) {
//    /**
//     * authentifier un client
//     */
//    fun login(loginClient: String, pswClient : String) = unauthorizedService.login(loginClient, pswClient)
//
//    /**
//     * ajouter un client
//     */
//    fun ajoutClient(
//        loginClient : String,
//        pswClient : String,
//        emailClient : String,
//        nomClient : String,
//        prenomClient : String
//    ) = unauthorizedService.ajoutClient(loginClient, pswClient,emailClient, nomClient, prenomClient)
//
//    /**
//     * modifier un client
//     */
//    fun modifierClient(
//        loginClient: String,
//        pswClient: String,
//        emailClient: String,
//        nomClient: String,
//        prenomClient: String
//    ) = authorizedService.modifierClient(loginClient, pswClient, emailClient,nomClient,prenomClient)
//
//}