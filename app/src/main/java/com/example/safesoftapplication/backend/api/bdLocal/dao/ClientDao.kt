package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import io.reactivex.Completable

@Dao
interface ClientDao {

    /**
     * recuperer tous les clients
     */
    @Query("select * from clientEntity")
    fun recupToutClients(): LiveData<List<ClientEntity>>

    /**
     * recuperer les informations d'un client
     */
    @Query("select * from clientEntity where idClient = :idClient")
    fun recupClient(idClient : Int): LiveData<ClientEntity>

    /**
     * deconnecter un client
     */
    @Query("UPDATE cliententity SET LOGGED = 0")
    fun logOut(): Completable

    /**
     * modifier les informations du client
     */
    @Update
    suspend fun modifierClient(vararg client : ClientEntity)


}