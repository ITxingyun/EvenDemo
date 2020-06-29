package com.xingyun.library

import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

class MyApp : Application() {

    private lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        refWatcher = LeakCanary.install(this)
    }


    companion object {
        private var refWatcher: RefWatcher? = null

        fun getRefWatcher(context: Context): RefWatcher? = refWatcher
    }
}