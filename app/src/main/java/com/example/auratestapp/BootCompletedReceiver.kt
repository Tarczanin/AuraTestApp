package com.example.auratestapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.auratestapp.utils.dispatchPeriodicJob
import com.example.auratestapp.workers.PeriodicWorkClass
import java.lang.Boolean

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        // todo save data about boot completed to DB
        // get data from DB
        context.dispatchPeriodicJob(PeriodicWorkClass::class.java)
    }
}

// todo move to separate file
data class NotificationEventData(
    val bootTimeStamp: String,
)