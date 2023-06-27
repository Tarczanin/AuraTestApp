package com.example.auratestapp.utils

import android.content.Context
import android.text.format.DateUtils
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import java.util.concurrent.TimeUnit

// todo replace texts by constants
fun Context.dispatchPeriodicJob(workerClass: Class<out Worker?>, constraints: Constraints? = null) {

    val inputData = Data.Builder().putBoolean("SCHEDULED", true).build()

    val builder: PeriodicWorkRequest.Builder = PeriodicWorkRequest.Builder(
        workerClass = workerClass,
        repeatInterval = REPEAT_INTERVAL,
        repeatIntervalTimeUnit = TimeUnit.MILLISECONDS,
        flexInterval = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS,
        flexIntervalTimeUnit = TimeUnit.MILLISECONDS
    ).setInputData(inputData)

    constraints?.let { builder.setConstraints(it) }

    val request: PeriodicWorkRequest = builder.build()
    WorkManager.getInstance(this).enqueueUniquePeriodicWork("PeriodicWorkTag", ExistingPeriodicWorkPolicy.UPDATE, request)
}

// todo move to constants
const val REPEAT_INTERVAL = 15 * DateUtils.MINUTE_IN_MILLIS