package com.example.safesoftapplication.di

import com.example.safesoftapplication.backend.api.api.reponses.contact.InfosOrganismeResponse
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
    fun provideAuthService(@Named("secure_retro") retrofit: Retrofit):
            AuthServices = retrofit.create(AuthServices::class.java)

    @Singleton
    @Provides
    fun provideCatalogueService(@Named("normal_retro") retrofit: Retrofit):
            CatalogueService = retrofit.create(CatalogueService::class.java)

    @Singleton
    @Provides
    fun provideContactService(@Named("contact_retro") retrofit: Retrofit):
            ContactServices = retrofit.create(ContactServices::class.java)

    @Singleton
    @Provides
    fun provideDetailsAchatsService(@Named("achat_retro") retrofit: Retrofit):
            DetailsAchatsServices = retrofit.create(DetailsAchatsServices::class.java)

    @Singleton
    @Provides
    fun provideDetailsProduitService(@Named("detail_produit_retro") retrofit: Retrofit):
            DetailsProduitServices = retrofit.create(DetailsProduitServices::class.java)

    @Singleton
    @Provides
    fun provideInscriptionService(@Named("inscription_retro") retrofit: Retrofit):
            InscriptionServices = retrofit.create(InscriptionServices::class.java)

    @Singleton
    @Provides
    @Named("commendes_retro")
    fun provideMesCommandesService(@Named("commendes_retro") retrofit: Retrofit):
            MesCommandesServices = retrofit.create(MesCommandesServices::class.java)

    @Singleton
    @Provides
    @Named("compte_retro")
    fun provideMonCompteService(@Named("compte_retro") retrofit: Retrofit):
            MonCompteServices = retrofit.create(MonCompteServices::class.java)

    @Singleton
    @Provides
    @Named("mon_panier_retro")
    fun provideMonPanierService(@Named("mon_panier_retro") retrofit: Retrofit):
            MonPanierServices = retrofit.create(MonPanierServices::class.java)

    @Singleton
    @Provides
    @Named("recherche_retro")
    fun provideRechercheService(@Named("recherche_retro") retrofit: Retrofit):
            RechercheService = retrofit.create(RechercheService::class.java)
}