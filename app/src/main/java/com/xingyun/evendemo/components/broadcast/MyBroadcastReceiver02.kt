package com.xingyun.evendemo.components.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast
import com.xingyun.evendemo.utils.EvenLog

class MyBroadcastReceiver02 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            append("data: ${intent.getStringExtra("data")}\n")
            toString().also { log ->
                EvenLog.d(log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }


    companion object {
        const val ACTION_TEST_01 = "com.xingyun.evendemo.components.broadcast.TEST01"

        fun getIntentFilter() =
            IntentFilter().apply {
                addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
                addAction(ACTION_TEST_01)
            }
    }

}