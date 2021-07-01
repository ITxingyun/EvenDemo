package com.xingyun.frame.hilt

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(MyCustomComponent::class)
interface MyCustomEntryPoint {
    fun getBar(): Bar
}