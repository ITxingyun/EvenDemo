package com.example.frame.okhttp

import okhttp3.Interceptor
import okhttp3.Response

class NetworkCacheInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        var cacheControl = request.cacheControl().toString()
        if (cacheControl.isEmpty()) {
            cacheControl = "public, max-age=60"
        }

        return response.newBuilder()
            .header("Cache-Control", cacheControl)
            .removeHeader("Pragma")
            .build()
    }

}