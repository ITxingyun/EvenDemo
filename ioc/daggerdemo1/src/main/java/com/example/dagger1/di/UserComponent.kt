package com.example.dagger1.di

import com.example.dagger1.MainActivity
import dagger.Component

@UserScope
@Component(modules = [UserModule::class], dependencies = [ApplicationComponent::class])
interface UserComponent {
    fun inject(activity: MainActivity)
}