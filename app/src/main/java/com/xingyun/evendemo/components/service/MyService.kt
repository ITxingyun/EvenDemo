package com.xingyun.evendemo.components.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    private val myBinder = MyBinder(this)

    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand -> flags = $flags and startId = $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    fun process() {
        Log.d(TAG, "Service is processing something")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    class MyBinder(private val myService: MyService) : Binder() {
        fun test() {
            myService.process()
        }
    }

    companion object {
        const val TAG = "MyService"
    }
}