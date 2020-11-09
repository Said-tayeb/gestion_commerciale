package com.example.safesoftapplication.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.safesoftapplication.backend.api.bdLocal.BaseDonneesLocal
import com.example.safesoftapplication.backend.api.bdLocal.dao.CatalogueDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.ClientDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.InfosOrganismeDao
import com.example.safesoftapplication.backend.api.bdLocal.dao.PanierDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class BDLocalModules  {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): BaseDonneesLocal {
        val callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL(
                    "INSERT INTO clients (" +
                            "loginClient, pswClient, emailClient, nomClient, prenomClient, LOGGED" +
                            ") VALUES" +
                            " ('said', 'said', 'said@gmail.com', 'tayeb', 'said', 0);"
                )
            }
        }
        return Room.databaseBuilder(
            application,
            BaseDonneesLocal::class.java,
            "safedatabase"
        ).addCallback(callback)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideClientDao(db: BaseDonneesLocal): ClientDao = db.clientDao()

    @Provides
    @Singleton
    fun provideCatalogueDao(db: BaseDonneesLocal): CatalogueDao = db.produitDao()

    @Provides
    @Singleton
    fun provideInfosOrganismeDao(db: BaseDonneesLocal): InfosOrganismeDao = db.infosOrganismeDao()

    @Provides
    @Singleton
    fun providePanierDao(db: BaseDonneesLocal): PanierDao = db.panierDao()



}