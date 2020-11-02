package com.example.safesoftapplication.ViewModel

import android.util.Log
import com.example.safesoftapplication.backend.api.reponses.authResponse.ClientsResponse

class AuthentifivationVM{

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