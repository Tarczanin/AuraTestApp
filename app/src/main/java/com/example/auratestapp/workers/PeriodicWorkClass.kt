package com.example.auratestapp.workers

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.auratestapp.MainActivity
import com.example.auratestapp.NotificationEventData
import com.example.auratestapp.R
import com.example.auratestapp.utils.defaultImmutableIntentFlags

class PeriodicWorkClass(
    private val context: Context,
    params: WorkerParameters,
    private val notificationInfoList: List<NotificationEventData>?
) : Worker(context, params) {
    override fun doWork(): Result {

        val notificationIntent = Intent(context, MainActivity::class.java).apply {
            // todo set flags??
        }
        val servicePendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, defaultImmutableIntentFlags())

        val notificationText = if (notificationInfoList.isNullOrEmpty()) {
            "No boots detected" // todo move to strings
        } else if (notificationInfoList.size == 1) {
            "The boot was detected with the timestamp = ${notificationInfoList[0].bootTimeStamp}"  // todo move to strings
        } else {
            // todo convert last two bootTimeStamp to Date and calculate delta (notificationInfoList[size].bootTimeStamp - notificationInfoList[size -1].bootTimeStamp
            val delta = 20 // todo in minutes ??
            "Last boots time delta = ${delta}" // todo move to strings
        }

        val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, "CHANNEL_ID")
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(notificationText)
            .setWhen(System.currentTimeMillis())
            .setContentIntent(servicePendingIntent)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify("NOTIFICATION_TAG", NOTIFICATION_ID, notificationBuilder.build())

        return Result.success()
    }
}

// todo move to Constants
const val NOTIFICATION_ID = 15