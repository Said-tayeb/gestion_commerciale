package com.example.safesoftapplication.vM.contactVM

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.example.safesoftapplication.backend.api.bdLocal.dao.InfosOrganismeDao
import com.example.safesoftapplication.backend.api.bdLocal.entity.InfosOrganismeEntity

class ContactVM @ViewModelInject constructor(
    val dataBase : InfosOrganismeDao,
    application: Application
) : AndroidViewModel(application)
{
    var nomOrganisme  : String = "Nom : Safe Soft"
    var emailOrganisme  : String = "Email : saf@gmail.com"
    var telephoneOrganisme  : String = "Téléphone : (+213) 655 365 148"
    var adresseOrganisme  : String = "Adressse : Mohammadia, Mohammadia Mall, Alger, Algérie"
    var codePostalOrganisme   : String = "Code postal : 16058"

    val nomOrganismeV  : String = "Safe Soft"
    val emailOrganismeV  : String = "saf@gmail.com"
    val telephoneOrganismeV  : String = "(+213) 655 365 148"
    val adresseOrganismeV  : String = "Mohammadia, Mohammadia Mall, Alger, Algérie"
    val codePostalOrganismeV   : String = "16058"

    var infosOrganismeEntity = InfosOrganismeEntity(
        0,
        nomOrganismeV,
        emailOrganismeV,
        telephoneOrganismeV,
        adresseOrganismeV,
        codePostalOrganismeV
    )



}