package com.xingyun.frame.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Singleton
    @Provides
    fun provideUserProfile(user: User): UserProfile {
        return UserProfile(user)
    }

    @Provides
    fun provideUserProfile2(user: User): UserProfile2 {
        return UserProfile2(user)
    }

}