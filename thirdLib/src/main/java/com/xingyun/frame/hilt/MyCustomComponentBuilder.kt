package com.xingyun.frame.hilt

import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface MyCustomComponentBuilder {
    fun fooSeedData(@BindsInstance foo: Foo): MyCustomComponentBuilder

    fun build(): MyCustomComponent
}