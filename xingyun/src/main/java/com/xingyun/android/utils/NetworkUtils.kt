package com.xingyun.android.utils

import android.content.Context
import android.net.ConnectivityManager
import com.xingyun.android.http.api.ApiResponse
import com.xingyun.android.http.api.XResult
import com.xingyun.android.http.exception.DataException
import java.io.IOException

suspend fun <T : Any> apiCall(call: suspend () -> ApiResponse<T>): XResult<T> {
    return try {
        val response = call()
        if (response.errorCode == -1) {
            XResult.Error(DataException(response.errorMsg))
        } else {
            XResult.Success(response.data)
        }
    } catch (e: Exception) {
        XResult.Error(IOException(e.message))
    }
}

fun isNetworkAvailable(context: Context): Boolean {
    val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = manager.activeNetworkInfo
    return !(null == info || !info.isAvailable)
}