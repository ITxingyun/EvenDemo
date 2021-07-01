package com.xingyun.frame.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class UserBinds {

    @Binds
    abstract fun bindLoader(loader: UserProfileLoader): IUserProfileLoader

}