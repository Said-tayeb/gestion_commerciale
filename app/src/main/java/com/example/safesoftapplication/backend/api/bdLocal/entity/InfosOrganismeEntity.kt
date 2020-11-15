package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "infosOrganismes", indices = [Index(value = ["idInfosOrganisme"], unique = true)])
data class InfosOrganismeEntity (
    @PrimaryKey(autoGenerate = true) val idInfosOrganisme: Int,
    @ColumnInfo(name = "nomOrganisme ") val nomOrganisme  : String,
    @ColumnInfo(name = "emailOrganisme ") val emailOrganisme  : String,
    @ColumnInfo(name = "telephoneOrganisme ") val telephoneOrganisme  : String,
    @ColumnInfo(name = "adresseOrganisme ") val adresseOrganisme  : String,
    @ColumnInfo(name = "codePostalOrganisme  ") val codePostalOrganisme   : String
)