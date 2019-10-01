package com.example.alarmsample

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RebootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            alarmManager?.setRepeating(
//                AlarmManager.RTC_WAKEUP,
//                cal.timeInMillis,
//                1000 * 60,
//                pendingIntent
//            )
        }
    }
}
