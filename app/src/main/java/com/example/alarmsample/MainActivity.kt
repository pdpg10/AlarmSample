package com.example.alarmsample

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    //    private val handler = Handler()
    private var c = 0
    private val thread = HandlerThread("HandlerThread")
    private val executor: ExecutorService = Executors.newFixedThreadPool(
        Runtime.getRuntime().availableProcessors() * 2
    )
    private val sd = SimpleDateFormat("ss", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        thread.start()
        val handler = Handler(thread.looper)
        val uiHandler = Handler()

        fab.setOnClickListener {
            //            handler.post {
//
//            }
            executor.execute {
                (0..100).forEach { _ ->
                    Thread.sleep(1000)
                    uiHandler.post { tv_top.text = sd.format(Date()) }
                }
            }

            executor.execute {
                (0..100).forEach { _ ->
                    Thread.sleep(2000)
                    uiHandler.post { tv_bottom.text = sd.format(Date()) }
                }
            }
            executor.execute {
                (0..100).forEach { _ ->
                    Thread.sleep(3000)
                    uiHandler.post { tv_left.text = sd.format(Date()) }
                }
            }

            executor.execute {
                (0..100).forEach { _ ->
                    Thread.sleep(4000)
                    uiHandler.post { tv_right.text = sd.format(Date()) }
                }
            }

        }
    }

    inner class MyRunnable : Runnable {
        override fun run() {
//            handler.postDelayed(this, 1000)
//            tv.text = "${c++}"
        }
    }

    override fun onStop() {
        super.onStop()
        executor.shutdown()
    }
}
