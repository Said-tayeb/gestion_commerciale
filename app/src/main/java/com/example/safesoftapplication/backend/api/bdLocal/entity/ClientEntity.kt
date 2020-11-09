package com.example.safesoftapplication.backend.api.bdLocal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "clients", indices = [Index(value = ["loginClient"], unique = true)])
data class ClientEntity (
    @PrimaryKey(autoGenerate = true) var idClient: Int,
    @ColumnInfo(name = "loginClient") var loginClient : String,
    @ColumnInfo(name = "pswClient") var pswClient : String,
    @ColumnInfo(name = "emailClient") var emailClient : String,
    @ColumnInfo(name = "nomClient") var nomClient : String,
    @ColumnInfo(name = "prenomClient") var prenomClient : String,
    @ColumnInfo(name = "LOGGED") var LOGGED : String,

    )