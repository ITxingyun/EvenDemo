package com.example.dagger1.di

import com.example.dagger1.bean.User
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @UserScope
    @Provides
    fun provideUser(): User {
        return User()
    }

}