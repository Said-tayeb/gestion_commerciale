package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

@Dao
interface CommandesDao {

    /**
     * recuperer toutes les commandes de la base de donnees
     */
//    @Query("select * from commandes ")
//    fun recupToutCommandes(): LiveData<List<CommandeEntity>>

}