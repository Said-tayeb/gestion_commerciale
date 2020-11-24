package com.example.safesoftapplication.vM

import androidx.hilt.lifecycle.ViewModelInject
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao

class DetailsProduitVM @ViewModelInject constructor(
    val detailProduitDao: CatalogueDao

) :BaseViewModel() {

    fun getProduit( idProduit: Int) = detailProduitDao.recupProduit(idProduit)
}