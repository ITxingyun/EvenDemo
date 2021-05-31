package com.xingyun.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class XYApplication : Application() {


    override fun onCreate() {
        super.onCreate()

    }


}