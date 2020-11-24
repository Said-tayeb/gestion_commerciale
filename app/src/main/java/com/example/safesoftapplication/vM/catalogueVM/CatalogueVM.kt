package com.example.safesoftapplication.vM.catalogueVM

import android.util.Log
import com.example.safesoftapplication.vM.BaseViewModel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse.produitsResponse
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.repository.CatalogueRepository
import com.example.safesoftapplication.utils.Resource
import io.reactivex.schedulers.Schedulers


class CatalogueVM @ViewModelInject constructor(
    val catalogueRepo: CatalogueRepository,

    ) : BaseViewModel() {

    // Récupère les donnes du Dao:
    fun getAllProduits(): LiveData<Resource<List<ProduitEntity>>> {

        val data = MutableLiveData<Resource<List<ProduitEntity>>>()
        enqueue(catalogueRepo.getAllProduits(), data)
        return data
    }



//    fun affiche() {
//        val data = getProduit()
//        Log.d("data", "mes data  :" + data.value?.data?.get(0)?.idProduit)
//    }

//    private fun saveProduct(vararg products: ProduitEntity): LiveData<Resource<Int>> {
//        val data = MutableLiveData<Resource<Int>>()
//        enqueue(catalogueRepo.insertDBserver(products), data)
//        return data
//    }

    // Récupère les données du serveur et es ajoute a la base de donnée locale
    fun getProduit() {
        val resulut = catalogueRepo.getAllProduitsServeur().subscribeOn(Schedulers.io())
            .flatMapCompletable {
                catalogueRepo.insertDBserver(it.map {
                    ProduitEntity(
                        it.idProduit,
                        it.titreProduit,
                        it.prixProduit.toDouble(),
                        it.descriptionProduit,
                        it.categorieProduit,
                        it.stockProduit.toDouble(),
                        it.imageProduit
                    )
                }.toTypedArray())
            }.onErrorComplete {
                it.printStackTrace()
                false
            }.doOnComplete {
                Log.d("TAAAAAAAAAG", "getProduit: succeeeeeeeeeeeeessssss")
            }.observeOn(Schedulers.io()).subscribe()


    }




}