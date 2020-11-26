package com.example.safesoftapplication.vM.contactVM

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safesoftapplication.backend.api.bdLocal.dao.InfosOrganismeDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity
import kotlinx.coroutines.launch

class ContactVM @ViewModelInject constructor(
    val dataBase : InfosOrganismeDao,
    application: Application
) : AndroidViewModel(application)
{
    //declaration
    private var _infosOrganisme = MutableLiveData<InfosOrganismeEntity>()
    val infosOrganisme : LiveData<InfosOrganismeEntity>
        get() = _infosOrganisme
    val nomOrganismeV  : String = "Safe Soft"
    val emailOrganismeV  : String = "saf@gmail.com"
    val telephoneOrganismeV  : String = "0655365148"
    val adresseOrganismeV  : String = "Mohammadia, Mohammadia Mall, Alger, Algérie"
    val codePostalOrganismeV   : String = "16058"

    val infosOrganismeDefault = InfosOrganismeEntity(
        0,
        nomOrganismeV,
        emailOrganismeV,
        telephoneOrganismeV,
        adresseOrganismeV,
        codePostalOrganismeV
    )

    var infosOrganismeEntityInit = InfosOrganismeEntity(
        0,"aucun","aucun","","aucun","aucun"
    )

    var nomOrganisme  : String = "Nom : "+infosOrganisme.value?.nomOrganisme
    var emailOrganisme  : String = "Email : "+ infosOrganisme.value?.emailOrganisme
    var telephoneOrganisme  : String = "Téléphone : "+ infosOrganisme.value?.telephoneOrganisme
    var adresseOrganisme  : String = "Adressse : "+ infosOrganisme.value?.adresseOrganisme
    var codePostalOrganisme   : String = "Code postal : "+ infosOrganisme.value?.codePostalOrganisme

    var infosOrganismeEntity = InfosOrganismeEntity(
        0,
        nomOrganismeV,
        emailOrganismeV,
        telephoneOrganismeV,
        adresseOrganismeV,
        codePostalOrganismeV
    )

    /**
     * recuperer les donnees de la base de donnes
     */
    suspend fun recupInfosOrganismeDataBase() : InfosOrganismeEntity{
        var infosOrganismeEntity = dataBase.recupInfosOrganisme()
        //Log.d("baseDonnees", "______"+ infosOrganismeEntity.nomOrganisme)
        return infosOrganismeEntity
    }

    /**
     * infos organisme de la base avec une corountine
     */
    fun recupInfosOrganisme(){
        viewModelScope.launch {
            _infosOrganisme.value = recupInfosOrganismeDataBase()
        }
    }

    fun recup(){
        _infosOrganisme.value = infosOrganismeDefault
    }
}