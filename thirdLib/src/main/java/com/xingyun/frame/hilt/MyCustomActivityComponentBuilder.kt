package com.xingyun.frame.hilt

import android.app.Activity
import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface MyCustomActivityComponentBuilder {

    fun activity(@BindsInstance activity: Activity): MyCustomActivityComponentBuilder

    fun build(): MyCustomActivityComponent
}