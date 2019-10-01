package com.example.alarmsample

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Single Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            NotificationManagerCompat
                .from(this)
                .createNotificationChannel(channel)
        }
    }
}
