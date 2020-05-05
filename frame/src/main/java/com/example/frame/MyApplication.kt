package com.example.frame

import android.app.Application
import com.example.frame.eventbus.MyEventBusIndex
import org.greenrobot.eventbus.EventBus

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initEventBus()
    }

    private fun initEventBus() {
        EventBus.builder()
            .addIndex(MyEventBusIndex())
            .eventInheritance(true)
            .strictMethodVerification(true)
            .ignoreGeneratedIndex(false)
            .installDefaultEventBus()
    }

}