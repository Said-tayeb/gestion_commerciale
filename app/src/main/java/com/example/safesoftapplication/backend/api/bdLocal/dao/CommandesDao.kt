package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

@Dao
interface CommandesDao {

    /**
     * recuperer toutes les commandes de la base de donnees
     */
    @Query("select * from commandes ")
    fun recupToutCommandes(): LiveData<List<CommandeEntity>>

    /**
     * ajouter une commande a la base de donnees local
     */
    @Insert
        suspend fun ajoutCommande(commande : CommandeEntity)

    /**
     * modifier une commande
     */
    @Update
        suspend fun modiferCommande(commande: CommandeEntity)

}