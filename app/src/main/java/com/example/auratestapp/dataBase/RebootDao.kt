package com.example.auratestapp.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.auratestapp.NotificationEventData

@Dao
interface RebootDao {

    @Insert
    suspend fun insertUser(user: NotificationEventData)

    @Query("SELECT * FROM reboot_data")
    suspend fun getUsers(): List<NotificationEventData>
}