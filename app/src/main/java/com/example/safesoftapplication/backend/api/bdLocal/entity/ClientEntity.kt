package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "clients", indices = [Index(value = ["loginClient"], unique = true)])
data class ClientEntity (
    @PrimaryKey(autoGenerate = true) val idClient: Int,
    @ColumnInfo(name = "loginClient") val loginClient: String,
    @ColumnInfo(name = "pswClient") val pswClient: String,
    @ColumnInfo(name = "nomClient") val firstName: String,
    @ColumnInfo(name = "prenomClient") val lastName: String,
    @ColumnInfo(name = "LOGGED") val logged: Boolean
)