package com.xingyun.storage.di

import com.xingyun.storage.data.local.ILocalArticleDataSource
import com.xingyun.storage.data.local.LocalArticleDataSource
import com.xingyun.storage.data.remote.IRemoteArticleDataSource
import com.xingyun.storage.data.remote.RemoteArticleDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindRemoteArticleDataSource(remoteArticleDataSource: RemoteArticleDataSource): IRemoteArticleDataSource

    @Binds
    abstract fun bindLocalArticleDataSource(localArticleDataSource: LocalArticleDataSource): ILocalArticleDataSource

}