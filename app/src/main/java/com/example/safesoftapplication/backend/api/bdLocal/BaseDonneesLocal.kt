package com.example.safesoftapplication.backend.api.bdLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
            entities = [
            ClientEntity::class,
            ProduitEntity::class,
            InfosOrganismeEntity::class,
            PanierEntity::class],
            version = 1
)

abstract class BaseDonneesLocal : RoomDatabase()  {

    abstract fun clientDao(): ClientDao

    abstract fun produitDao() : CatalogueDao

    abstract  fun infosOrganismeDao() : InfosOrganismeDao

    abstract fun panierDao() : PanierDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDonneesLocal? = null

        fun getInstance(context: Context): BaseDonneesLocal {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BaseDonneesLocal::class.java,
                        "base_de_donnees_safe"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}