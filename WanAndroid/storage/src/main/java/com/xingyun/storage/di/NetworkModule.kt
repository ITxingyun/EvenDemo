package com.xingyun.storage.di

import android.content.Context
import com.xingyun.storage.BuildConfig
import com.xingyun.storage.http.api.WebService
import com.xingyun.storage.http.cookies.CookiesManager
import com.xingyun.storage.utils.isNetworkAvailable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://wanandroid.com/"


    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().also { builder ->
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                })
            }
            val cacheInterceptor = Interceptor { chain: Interceptor.Chain ->
                var request = chain.request()
                if (!isNetworkAvailable(context)) {
                    // 无网时强制使用数据缓存，以提升用户体验。
                    request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
                }
                val response = chain.proceed(request)
                if (isNetworkAvailable(context)) {
                    val maxAge = 0
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                        .header("Cache-Control", "public, max-age=$maxAge")
                        .removeHeader("Pragma")
                        .build()
                } else {
                    // 无网络时，设置超时为4周
                    val maxStale = 60 * 60 * 24 * 28
                    response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                        .removeHeader("Pragma")
                        .build()
                }
                response
            }
            builder.addInterceptor(cacheInterceptor)
        }
            .cookieJar(CookiesManager(context))
//            .addInterceptor(NetworkInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

}
