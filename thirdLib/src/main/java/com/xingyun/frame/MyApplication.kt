package com.xingyun.frame

import android.app.Application
import android.os.Build
import com.alibaba.android.arouter.launcher.ARouter
import com.xingyun.frame.hilt.User
import com.xingyun.frame.hilt.UserProfile
import com.xingyun.frame.hilt.UserProfile2
import com.xingyun.library.BuildConfig
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
        initARouter()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) { // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }

    private fun initEventBus() {
        EventBus.builder()
            .eventInheritance(true)
            .strictMethodVerification(true)
            .ignoreGeneratedIndex(false)
            .installDefaultEventBus()
    }

}