package com.example.safesoftapplication.backend.api.bdLocal

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
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
                    val callback = object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            db.execSQL("INSERT INTO infosOrganismes VALUES ('Safe Soft', 'saf@gmail.com','0655365148', 'Mohammadia, Mohammadia Mall, Alger, Algérie', '16058');")

                            INSTANCE = instance
                            Log.d("baseDonnees", "la base de donnees a ete creer")
                        }
                    }
                }
                return instance
            }
        }
    }
}