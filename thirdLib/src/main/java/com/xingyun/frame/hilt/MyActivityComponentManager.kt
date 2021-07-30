package com.xingyun.frame.hilt

import android.app.Activity
import android.app.Application
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
import dagger.hilt.internal.GeneratedComponentManager

class MyActivityComponentManager(private val activity: Activity): GeneratedComponentManager<Any>  {

    @EntryPoint
    @InstallIn(MyCustomActivityComponent::class)
    interface MyCustomActivityEntryPoint {
        fun activityComponentBuilder(): MyCustomActivityComponentBuilder
    }

    @Volatile
    private var component: Any? = null
    private val componentLock = Any()


    override fun generatedComponent(): Any? {
        if (component == null) {
            synchronized(componentLock) {
                if (component == null) {
                    component = createComponent();
                }
            }
        }
        return component
    }

    fun createComponent(): Any {
        if (activity.application !is GeneratedComponentManager<*>) {
            if (Application::class.java == activity.application.javaClass) {
                throw IllegalStateException(
                    "Hilt Activity must be attached to an @HiltAndroidApp Application. "
                            + "Did you forget to specify your Application's class name in your manifest's "
                            + "<application />'s android:name attribute?"
                )
            }
            throw IllegalStateException(
                (
                        "Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: "
                                + activity.application.javaClass)
            )
        }
        return EntryPoints.get(activity.application, MyCustomActivityEntryPoint::class.java)
            .activityComponentBuilder()
            .activity(activity)
            .build()
    }
}