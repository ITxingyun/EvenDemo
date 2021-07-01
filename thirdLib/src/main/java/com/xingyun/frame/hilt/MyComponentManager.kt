package com.xingyun.frame.hilt

import dagger.hilt.EntryPoints
import javax.inject.Inject

class MyComponentManager @Inject constructor(val componentBuilder: MyCustomComponentBuilder) {

    fun doSomething(foo: Foo) {
        val component = componentBuilder.fooSeedData(foo).build()
        val bar = EntryPoints.get(component, MyCustomEntryPoint::class.java).getBar()

        // Don't forget to hold on to the component instance if you need to!
    }
}