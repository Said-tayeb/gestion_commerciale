package com.example.safesoftapplication.vM.catalogueVM

import android.util.Log
import com.example.safesoftapplication.vM.BaseViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.repository.CatalogueRepository
import com.example.safesoftapplication.utils.Resource
import io.reactivex.schedulers.Schedulers

class CatalogueVM @ViewModelInject constructor(
    val catalogueRepo: CatalogueRepository,
    val catalogueDao: CatalogueDao,

    ) : BaseViewModel() {

    private val _navigateToDetailsProduit = MutableLiveData<Int>()
    val navigateToDetailsProduit: LiveData<Int>
        get() = _navigateToDetailsProduit


    // Récupère les donnes du Dao:
    fun getAllProduits(): LiveData<Resource<List<ProduitEntity>>> {
        val data = MutableLiveData<Resource<List<ProduitEntity>>>()
        enqueue(catalogueRepo.getAllProduits(), data)
        return data
    }

    fun clicProduit(idProduit: Int) {
        _navigateToDetailsProduit.value = idProduit
    }

    fun ProduitDetailsNavgated() {
        _navigateToDetailsProduit.value = null
    }

    fun recupProduit() = catalogueDao.recupProduit()

    // Récupère les données du serveur et es ajoute a la base de donnée locale
    fun getProduit() {
        val result = catalogueRepo.getAllProduitsServeur().subscribeOn(Schedulers.io())
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
            }.observeOn(Schedulers.io())
            .doOnError { it.printStackTrace() }
            .subscribe()
    }
}