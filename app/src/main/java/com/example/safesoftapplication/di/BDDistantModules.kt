package com.example.safesoftapplication.di

import com.example.safesoftapplication.backend.api.api.services.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class BDDistantModules {

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit):
            AuthServices = retrofit.create(AuthServices::class.java)

    @Singleton
    @Provides
    fun provideCatalogueService(retrofit: Retrofit):
            CatalogueService = retrofit.create(CatalogueService::class.java)

    @Singleton
    @Provides
    fun provideContactService(retrofit: Retrofit):
            ContactServices = retrofit.create(ContactServices::class.java)

    @Singleton
    @Provides
    fun provideDetailsAchatsService(retrofit: Retrofit):
            DetailsAchatsServices = retrofit.create(DetailsAchatsServices::class.java)

    @Singleton
    @Provides
    fun provideDetailsProduitService(retrofit: Retrofit):
            DetailsProduitServices = retrofit.create(DetailsProduitServices::class.java)

    @Singleton
    @Provides
    fun provideInscriptionService(retrofit: Retrofit):
            InscriptionServices = retrofit.create(InscriptionServices::class.java)

    @Singleton
    @Provides
    fun provideMesCommandesService(retrofit: Retrofit):
            MesCommandesServices = retrofit.create(MesCommandesServices::class.java)

    @Singleton
    @Provides
    fun provideMonCompteService(retrofit: Retrofit):
            MonCompteServices = retrofit.create(MonCompteServices::class.java)

    @Singleton
    @Provides
    fun provideMonPanierService(retrofit: Retrofit):
            MonPanierServices = retrofit.create(MonPanierServices::class.java)

    @Singleton
    @Provides
    fun provideRechercheService(retrofit: Retrofit):
            RechercheService = retrofit.create(RechercheService::class.java)


}