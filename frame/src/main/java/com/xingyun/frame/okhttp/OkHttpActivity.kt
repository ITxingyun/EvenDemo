package com.xingyun.frame.okhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xingyun.frame.R
import kotlinx.android.synthetic.main.activity_ok_http.*
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttpActivity : AppCompatActivity() {
    private val maxSize = 20 * 1024 * 1024L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)

        val okHttpClient =
            OkHttpClient
                .Builder()
                .addNetworkInterceptor(NetworkCacheInterceptor())
                .cache(Cache(applicationContext.cacheDir, maxSize))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()

        tv_execute.setOnClickListener {
            val request = Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build()

            okHttpClient.newCall(request).execute().use {
                println("同步: ${it.body()?.string()}")
            }

        }

        tv_enqueue.setOnClickListener {
            val request = Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build()
            val call = okHttpClient.newCall(request)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    println("异步: ${response.body()?.string()}")
                }

            })


        }
    }
}