package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity

@Dao
interface ClientDao {

    /**
     * recuperer les informations d'un client par rapport a son login
     */
    @Query("select * from clients where loginClient = :loginClient")
    fun recupClientsByLogin(loginClient: String): LiveData<ClientEntity>

    /**
     * recuperer tous les clients
     */
    @Query("select * from clients limit 1 ")
        suspend fun recupToutClients(): List<ClientEntity>

    /**
     * recuperer les informations d'un client
     */
    @Query("select * from clients where idClient = :idClient")
        fun recupClient(idClient: Int): LiveData<ClientEntity>

    /**
     * recuperer un client par son loginClient et mot de passe
     */
    @Query("SELECT * FROM clients WHERE loginClient = :loginClient and pswClient= :pswClient limit 1")
        suspend fun attemptLogin(loginClient: String, pswClient : String): ClientEntity

    /**
     * deconnecter un client
     */
    @Query("UPDATE clients SET LOGGED = 0")
        fun logOut()

    /**
     * modifier les informations du client
     */
    @Update
        fun modifierClient(client : ClientEntity)

    /**
     * recuperer les informations d'un client connecter
     */
    @Query("SELECT * FROM clients WHERE LOGGED = 1 LIMIT 1")
        suspend fun checkLogged(): ClientEntity?

    /**
     * ajouter un client a la base de donnees local
     */
    @Insert
        suspend fun ajoutClient(client : ClientEntity)

    /**
     * modifier le logged du client par rapport a son username
     */
    @Query("update clients set LOGGED = 1 where LoginClient = :loginClient")
        suspend fun logged(loginClient: String)

    @Query("update clients set LOGGED = 0 where LoginClient = :loginClient")
    suspend fun loggout(loginClient: String)
}