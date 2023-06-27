package com.example.auratestapp.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reboot_data")
data class RebootData(
    @PrimaryKey val id: Int,
    val bootTimeStamp: String,
)