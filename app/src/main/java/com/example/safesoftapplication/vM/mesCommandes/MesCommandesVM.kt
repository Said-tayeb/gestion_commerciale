package com.example.safesoftapplication.vM.mesCommandes

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity
import kotlinx.coroutines.launch

class MesCommandesVM @ViewModelInject constructor(
    val commandesDao: CommandesDao,
    val clientDao: ClientDao,
    application: Application
) : AndroidViewModel(application)
{

//
//    val mesCommandes = commandesDao.recupToutCommandes()

    //test
    val commandes1 = CommandeEntity(0, 1, 1, "11/12/2000","11/02/2001", 16, 9000 )
    val commandes2 = CommandeEntity(0, 1, 2, "02/05/2005", "02/05/2005", 3, 5500 )
    val commandes3 = CommandeEntity(0, 1, 3, "02/05/2005", "02/05/2005",  6, 3000 )
    val commandes4 = CommandeEntity(0, 1, 1, "02/05/2005", "02/05/2005",  16, 9300 )
    val commandes5 = CommandeEntity(0, 1, 1, "02/05/2005", "02/05/2005",  16, 3000 )
    val commandes6 = CommandeEntity(0, 1, 1, "02/05/2005", "02/05/2005",  16, 108000 )
    val commandes7 = CommandeEntity(0, 1, 1, "02/05/2005", "02/05/2005", 16, 30000 )
    val listCommandesTest = listOf<CommandeEntity>(commandes1, commandes2, commandes3, commandes4, commandes5, commandes6, commandes7)


    val _commande = MutableLiveData<List<CommandeEntity>>()
    val commande : LiveData<List<CommandeEntity>>
        get() = _commande

    fun recupToutCommandes() :LiveData<List<CommandeEntity>>{
        return commandesDao.recupToutCommandes()
    }

    fun ajoutCommande(){
        viewModelScope.launch {
            commandesDao.ajoutCommande(commandes1)
            commandesDao.ajoutCommande(commandes2)
            commandesDao.ajoutCommande(commandes3)
            commandesDao.ajoutCommande(commandes4)
            commandesDao.ajoutCommande(commandes5)
            commandesDao.ajoutCommande(commandes6)
            commandesDao.ajoutCommande(commandes7)
            Log.d("baseDonnees", "________ajout oui")
        }
    }
    /**
     * verifier si le client et connecter ou non
     */
    fun recupClientDatabase() : LiveData<ClientEntity>{
//        var a = MutableLiveData<ClientEntity>()
//       clientDao.checkLogged().observeForever({
//           a.value = it
//        })
//        return a
        return clientDao.checkLogged()
    }
}