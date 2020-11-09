package com.xingyun.evendemo.components.service

import android.app.IntentService
import android.content.Intent
import com.xingyun.evendemo.utils.EvenLog

class MyIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
        EvenLog.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        EvenLog.d(TAG, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        EvenLog.d(TAG, "onHandleIntent")
    }

    override fun onDestroy() {
        super.onDestroy()
        EvenLog.d(TAG, "onDestroy")
    }


    companion object {
        private const val TAG = "MyIntentService"
    }
}