package com.example.jetpack

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.jetpack.lifecycle.MyLifecycleObserver

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyLifecycleObserver("ProcessLifecycleOwner"))
    }
}