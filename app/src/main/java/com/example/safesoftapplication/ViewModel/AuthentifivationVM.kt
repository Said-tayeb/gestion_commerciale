package com.example.safesoftapplication.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.backend.api.api.repository.AuthRepository
import com.example.safesoftapplication.backend.api.bdLocal.repositoryBdLocal.ClientRepository
import com.example.safesoftapplication.model.Client

class AuthentifivationVM @ViewModelInject constructor(
    private val authRepository : AuthRepository,
    private val clientRepository: ClientRepository
) : BaseViewModel() {
//    val idClient : String = savedStateHandle["idClient"] ?: throw IllegalArgumentException("missing user idClient")
//    val client : LiveData<Client> = TODO()

    fun verifier(listClients : List<ClientsResponse>, loginClient : String, pswClient : String):Boolean{
        var bool = false
        var j = 0
        while (!bool and (j < listClients.size)){
            if ((listClients.get(j).loginClient == loginClient) and(listClients.get(j).pswClient == pswClient) ){
                Log.d("login","trouvé")
                bool = true
            }
            j++
        }
        return bool
    }

}