package com.example.safesoftapplication.backend.api.bdLocal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.ClientEntity

@Dao
interface ClientDao {
    @Query("select * from clientEntity")
    fun getAll(): LiveData<List<ClientEntity>>
}