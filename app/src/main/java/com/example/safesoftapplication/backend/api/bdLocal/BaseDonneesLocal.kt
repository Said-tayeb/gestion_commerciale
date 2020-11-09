package com.example.safesoftapplication.backend.api.bdLocal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.InfosOrganismeDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity

@Database(
            entities = arrayOf(
            ClientEntity::class,
            ProduitEntity::class,
            InfosOrganismeEntity::class,
            PanierEntity::class),
            version = 1)

abstract class BaseDonneesLocal : RoomDatabase()  {
    abstract fun clientDao(): ClientDao
    abstract fun produitDao() : CatalogueDao
    abstract  fun infosOrganismeDao() : InfosOrganismeDao
    abstract fun panierDao() : PanierDao
}