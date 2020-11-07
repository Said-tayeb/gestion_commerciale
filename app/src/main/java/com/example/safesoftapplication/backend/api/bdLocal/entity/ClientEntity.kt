package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ClientEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "access_token") val accessToken: String,
    @ColumnInfo(name = "birth_date") val birthDate: Date
)