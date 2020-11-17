package com.xingyun.evendemo.components.service.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.xingyun.evendemo.utils.EvenLog

class MusicManagerService : Service() {
    private lateinit var binder: MusicPlayerBinder


    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        binder = MusicPlayerBinder()
        binder.onCreate()
        EvenLog.d(TAG, "onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        EvenLog.d(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    companion object {
        private const val TAG = "MusicManagerService"
    }

}