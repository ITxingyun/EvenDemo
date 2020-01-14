package com.xingyun.evendemo.http.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractServiceRetrofit {

    private var retrofit: Retrofit = Retrofit.Builder()
        .client(getOkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(getBaseUrl())
        .build()

    abstract fun getBaseUrl(): String

    private fun getOkHttpClient(): OkHttpClient =
        okHttpClient.newBuilder().apply {
            connectTimeout(CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            readTimeout(CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.HEADERS })
            addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                //do something for Header or Parameter ...
                chain.proceed(requestBuilder.build())
            }
        }.build()

    protected fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    private companion object {
        const val CONNECTION_TIME_OUT = 30000L
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
    }
}