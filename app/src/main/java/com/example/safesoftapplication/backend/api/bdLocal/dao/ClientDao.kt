package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ClientDao {

    /**
     * recuperer tous les clients
     */
    @Query("select * from clients")
    fun recupToutClients(): LiveData<List<ClientEntity>>

    /**
     * recuperer les informations d'un client
     */
    @Query("select * from clients where idClient = :idClient")
    fun recupClient(idClient : Int): LiveData<ClientEntity>

    /**
     * recuperer un client par son loginClient
     */
    @Query("SELECT * FROM clients WHERE loginClient = :loginClient")
    fun attemptLogin(loginClient: String): Single<ClientEntity>

    /**
     * deconnecter un client
     */
    @Query("UPDATE clients SET LOGGED = 0")
    fun logOut(): Completable

    /**
     * modifier les informations du client
     */
    @Update
    suspend fun modifierClient(vararg client : ClientEntity)


}