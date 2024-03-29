package com.xingyun.android.http.interceptor

import android.content.Context
import com.xingyun.android.utils.isNetworkAvailable
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val isNetworkAvailable = isNetworkAvailable(context)
        if (!isNetworkAvailable) {
            // 无网时强制使用数据缓存，以提升用户体验。
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        val response = chain.proceed(request)
        if (isNetworkAvailable) {
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
        return response
    }
}