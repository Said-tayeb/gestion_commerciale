package com.example.safesoftapplication.vM.mesCommandes

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.CommandesDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

class MesCommandesVM @ViewModelInject constructor(
    val commandesDao: CommandesDao,
    val clientDao: ClientDao,
    application: Application
) : AndroidViewModel(application)
{

//
//    val mesCommandes = commandesDao.recupToutCommandes()

    //test
    val commandes1 = CommandeEntity(1, 1, 1, 12.3.toLong(),12.4.toLong(), 16, 9000 )
    val commandes2 = CommandeEntity(2, 1, 2, 19.7.toLong(),22.7.toLong(), 3, 5500 )
    val commandes3 = CommandeEntity(3, 1, 3, 13.9.toLong(),15.4.toLong(), 6, 3000 )

    val listCommandesTest = listOf<CommandeEntity>(commandes1, commandes2, commandes3)

    val _commandeTest = MutableLiveData<List<CommandeEntity>>(listCommandesTest)
    val commandeTest : LiveData<List<CommandeEntity>>
        get() = _commandeTest

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