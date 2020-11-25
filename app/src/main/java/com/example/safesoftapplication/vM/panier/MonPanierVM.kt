package com.example.safesoftapplication.vM.panier

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import com.example.safesoftapplication.model.Client
import kotlinx.coroutines.launch
import java.lang.Exception

class MonPanierVM @ViewModelInject constructor(
    val panierDao: PanierDao,
    val clientDao: ClientDao,
    application: Application
) : AndroidViewModel(application)
{
    private val _navigateToDetailsProduit = MutableLiveData<Int>()
    val navigateToDetailsProduit : LiveData<Int>
        get() = _navigateToDetailsProduit

    private val _messageDelete = MutableLiveData<String>()
    val messageDelete : LiveData<String>
        get() = _messageDelete

    var idClient : Int = 0

    /**
     * verifier si le client et connecter ou non
     */
    fun recupClientDatabase() : LiveData<ClientEntity> {
        return clientDao.checkLogged()
    }

    /**
     * recuperer les informations d'un produit
     */
    fun recupToutProduits() : LiveData<List<PanierEntity>>{
        TODO()
    }
//    /**
//     * ajout d'un produit au panier
//     */
//    fun ajoutProduitPanier(){
//        var panier1 = PanierEntity(0,1, 1 , 9000.0)
//        var panier2 = PanierEntity(0,1, 2 , 3000.0)
//        viewModelScope.launch {
//            panierDao.ajoutProdPanier(panier1)
//            panierDao.ajoutProdPanier(panier2)
//        }
//    }

    /**
     * recuperer tous id client connecter
     */
    fun recupBD() {
        viewModelScope.launch {
            idClient = clientDao.recupIdClient()
        }
    }

    fun recupToutProdPanier(idClient: Int) : LiveData<List<PanierEntity>> {
        return panierDao.recupTousPanier(idClient)
    }

    fun clicProduit(idProduit : Int){
        _navigateToDetailsProduit.value = idProduit
    }

    fun ProduitDetailsNavgated(){
        _navigateToDetailsProduit.value = null
    }

    fun supProduitPanier(idProduit: Int){
        viewModelScope.launch {
            try {
                panierDao.supProduitPanierById(idProduit)
                _messageDelete.value = "Le produit à été retiré de votre"
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

}
