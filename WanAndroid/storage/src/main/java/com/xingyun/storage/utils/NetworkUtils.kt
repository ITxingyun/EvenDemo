package com.xingyun.storage.utils

import android.content.Context
import android.net.ConnectivityManager


fun isNetworkAvailable(context: Context): Boolean {
    val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = manager.activeNetworkInfo
    return !(null == info || !info.isAvailable)
}