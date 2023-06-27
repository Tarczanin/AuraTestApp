package com.example.auratestapp.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RebootData::class], version = 1, exportSchema = false)
abstract class AuraTestDatabase : RoomDatabase() {
    abstract fun userDao(): RebootDao

    companion object {
        private var INSTANCE: AuraTestDatabase? = null

        fun getInstance(context: Context): AuraTestDatabase? {
            if (INSTANCE == null) {
                synchronized(AuraTestDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AuraTestDatabase::class.java, "AuraTestDatabase-database"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }

    fun destroyInstance() {
        INSTANCE = null
    }
}

