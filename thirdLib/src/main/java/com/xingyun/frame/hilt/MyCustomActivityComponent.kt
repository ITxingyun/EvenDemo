package com.xingyun.frame.hilt

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface MyCustomActivityComponent {

}