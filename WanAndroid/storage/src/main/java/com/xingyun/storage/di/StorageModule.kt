package com.xingyun.storage.di

import com.xingyun.storage.data.db.AppDatabase
import com.xingyun.storage.data.local.ILocalArticleDataSource
import com.xingyun.storage.data.local.LocalArticleDataSource
import com.xingyun.storage.data.remote.IRemoteArticleDataSource
import com.xingyun.storage.data.remote.RemoteArticleDataSource
import com.xingyun.storage.http.api.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    fun provideRemoteArticleDataSource(service: WebService): IRemoteArticleDataSource {
        return RemoteArticleDataSource(service)
    }

    @Provides
    fun provideLocalArticleDataSource(appDatabase: AppDatabase): ILocalArticleDataSource {
        return LocalArticleDataSource(appDatabase)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}