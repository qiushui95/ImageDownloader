package me.yangcx.downloader.image.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat

object NotificationManager {
    const val CHANNEL_SIMPLE = "simple"

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannels(application: Application) {
        with(NotificationManagerCompat.from(application)) {
            createNotificationChannel(NotificationChannel(CHANNEL_SIMPLE, CHANNEL_SIMPLE, NotificationManager.IMPORTANCE_LOW))
        }
    }
}