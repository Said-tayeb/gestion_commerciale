package com.example.safesoftapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.AppelRetrofit
import com.example.safesoftapplication.backend.api.api.reponses.authResponse.ClientResponse
import com.example.safesoftapplication.backend.api.api.services.AuthServices
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class Repository @Inject constructor(
    private val authServices: AuthServices
)
{
    var BASE_URL="http://192.168.43.165/api/"
    lateinit var x : String
    val data = MutableLiveData<ClientResponse>()
//    auth.getUser(userId).enqueue(object : Callback<User> {
//    override fun onResponse(call: Call<User>, response: Response<User>) {
//        data.value = response.body()
//    }
//
//    // Error case is left out for brevity.
//    override fun onFailure(call: Call<User>, t: Throwable) {
//        TODO()
//    }
//})
}