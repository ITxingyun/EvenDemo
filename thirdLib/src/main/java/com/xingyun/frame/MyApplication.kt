package com.xingyun.frame

import android.app.Application
import org.greenrobot.eventbus.EventBus

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initEventBus()
    }

    private fun initEventBus() {
        EventBus.builder()
            .eventInheritance(true)
            .strictMethodVerification(true)
            .ignoreGeneratedIndex(false)
            .installDefaultEventBus()
    }

}