package com.xingyun.frame

import android.app.Application
import com.xingyun.frame.hilt.User
import com.xingyun.frame.hilt.UserProfile
import com.xingyun.frame.hilt.UserProfile2
import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    lateinit var user: User

    @Inject
    lateinit var userProfile: UserProfile

    @Inject
    lateinit var userProfile2: UserProfile2

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