package com.example.auratestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.work.Constraints
import com.example.auratestapp.dataBase.AuraTestDatabase
import com.example.auratestapp.utils.dispatchPeriodicJob
import com.example.auratestapp.workers.PeriodicWorkClass
import org.koin.android.java.KoinAndroidApplication.create
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeKoin()
        // tod  AuraTestDatabase.getInstance(this)
        // todo get data from DB
        dispatchPeriodicJob(PeriodicWorkClass::class.java, Constraints.Builder().setRequiresCharging(true).build())
    }

    private fun initializeKoin() {
        startKoin(
            create(this)
                .modules(appModule)
        )
    }

    companion object {
        lateinit var database: AuraTestDatabase
    }

    // todo clear DB data after Notification was shown ???
}



