package com.example.alarmsample

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*
import java.text.SimpleDateFormat
import java.util.*

const val CHANNEL_ID = "Single Notification app"

private const val REQ_CODE = 1001

class SecondActivity : AppCompatActivity() {
    private var notificationManager: NotificationManager? = null
        get() {
            if (field == null) {
                field = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            return field
        }

    private var alarmManager: AlarmManager? = null
        get() {
            if (field == null) {
                field = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            }
            return field
        }


    private val sd = SimpleDateFormat("ss", Locale.getDefault())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)



        fab.setOnClickListener {
            setAlarm()
        }
    }

    private fun setAlarm() {
        val cal = Calendar.getInstance()
            .apply {
                timeInMillis = System.currentTimeMillis()
                add(Calendar.SECOND, 10)
            }
        Log.d("setAlarm", "setAlarm time${sd.format(cal.time)}")

        val intent = Intent(this, SecondActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager?.setExact(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            pendingIntent
        )
    }


    private fun showNotification() {

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("My Notification")
            .setContentText("Some Text")
            .setSmallIcon(R.drawable.ic_favorite)


        notificationManager?.notify(1, builder.build())
    }

}
