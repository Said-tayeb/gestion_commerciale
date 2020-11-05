package com.example.safesoftapplication.ViewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientsResponse
import com.example.safesoftapplication.model.Client

class AuthentifivationVM(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val idClient : String = savedStateHandle["idClient"] ?: throw IllegalArgumentException("missing user id")
    val client : Client = TODO()
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