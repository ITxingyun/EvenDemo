package com.xingyun.evendemo.utils

import android.util.Log
import com.google.gson.Gson

class EvenLog {

    companion object {
        private const val TAG = "EvenChen"

        fun d(message: String) {
            Log.d(TAG, message)
        }

        fun d(position: String, message: String) {
            d("$position -> $message")
        }

    }

}

inline fun <reified T : Any> EvenLog.d(position: String, bean: T) {
    val toString = Gson().toJson(bean)
    EvenLog.d("$position -> $toString")
}