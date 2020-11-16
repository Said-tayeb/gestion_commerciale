package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity

@Dao
interface InfosOrganismeDao {

    /**
     * recuperer les informations de l'organisme
     */
    @Query("select * from infosOrganismes limit 1 ")
        suspend fun recupInfosOrganisme(): InfosOrganismeEntity

    /**
     * ajouter des donnees
     */
    @Insert
        suspend fun ajoutInfosOrganisme(infosOrganismeEntity: InfosOrganismeEntity)

}