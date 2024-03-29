package com.xingyun.frame.okhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xingyun.frame.R
import com.xingyun.frame.databinding.ActivityOkHttpBinding
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttpActivity : AppCompatActivity() {
    private val maxSize = 20 * 1024 * 1024L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        val binding = DataBindingUtil.setContentView<ActivityOkHttpBinding>(this, R.layout.activity_ok_http)

        val okHttpClient =
            OkHttpClient
                .Builder()
                .addNetworkInterceptor(NetworkCacheInterceptor())
                .cache(Cache(applicationContext.cacheDir, maxSize))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()

        binding.tvExecute.setOnClickListener {
            val request = Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build()

            okHttpClient.newCall(request).execute().use {
                println("同步: ${it.body()?.string()}")
            }

        }

        binding.tvEnqueue.setOnClickListener {
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