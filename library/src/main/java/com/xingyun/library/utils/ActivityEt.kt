package com.xingyun.library.utils

import android.app.Activity
import android.content.Intent

inline fun <reified T: Activity> Activity.start() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}