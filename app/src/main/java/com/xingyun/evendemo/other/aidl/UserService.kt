package com.xingyun.evendemo.other.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xingyun.evendemo.other.process.IUser

class UserService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
       return binder
    }

    private val binder = object : IUser.Stub() {
        override fun getUserName(): String {
            Log.e("Server", "user")
            return "ItXingYun"
        }
    }
}