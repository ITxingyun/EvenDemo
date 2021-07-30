package com.xingyun.frame.hilt

import android.app.Activity
import dagger.hilt.internal.GeneratedComponentManagerHolder

open class BaseHiltActivity : Activity(), GeneratedComponentManagerHolder {
    private val componentManagerLock = Any()

    @Volatile
    private var componentManager: MyActivityComponentManager? = null

    private var injected = false

    override fun generatedComponent(): Any? {
        return componentManager()?.generatedComponent()
    }

    override fun componentManager(): MyActivityComponentManager? {
        componentManager
        if (componentManager == null) {
            synchronized(componentManagerLock) {
                if (componentManager == null) {
                    componentManager = createComponentManager()
                }
            }
        }
        return componentManager
    }

    private fun createComponentManager(): MyActivityComponentManager {
        return MyActivityComponentManager(this)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        inject()
//    }
//
//    fun inject() {
//        if (!injected) {
//            injected = true
//            (generatedComponent() as MainActivity_GeneratedInjector?)!!.injectMainActivity(UnsafeCasts.unsafeCast(this))
//        }
//    }

}