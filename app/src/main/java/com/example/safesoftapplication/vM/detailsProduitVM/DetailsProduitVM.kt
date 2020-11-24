package com.example.safesoftapplication.vM.detailsProduitVM

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao

class DetailsProduitVM @ViewModelInject constructor(
    val produitDao: CatalogueDao,
    application: Application
) : AndroidViewModel(application){

//    private val _client
//    fun
}