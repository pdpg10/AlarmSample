package com.example.alarmsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val notificationManager = NotificationManagerCompat.from(context)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("My Notification")
            .setContentText("Some Text")
            .setSmallIcon(R.drawable.ic_favorite)

        notificationManager.notify(1, builder.build())
    }
}
