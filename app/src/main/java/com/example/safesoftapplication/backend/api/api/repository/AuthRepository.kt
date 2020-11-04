package com.example.safesoftapplication.backend.api.api.repository

import javax.inject.Inject
import javax.inject.Named
import com.example.safesoftapplication.backend.api.api.services.AuthServices
import com.example.safesoftapplication.model.Client

class AuthRepository @Inject constructor(
    @Named("non_auth_auth_service") private val unauthorizedService: AuthServices,
    @Named("auth_auth_service") private val authorizedService: AuthServices
) {
    fun login(loginClient: String, pswClient : String) = unauthorizedService.login(loginClient, pswClient)

    fun register(username: String, password: String, email: String) =
        unauthorizedService.register(username, email, password)

    fun updateUser(
        id: Int,
        username: String,
//        password: String,
        firstName: String,
        email: String,
        lastName: String
    ) = authorizedService.updateUser(id, username, email, /*password,*/ firstName, lastName)

    fun storeNotificationService(token: String) = authorizedService.storeNotificationToken(token)
}