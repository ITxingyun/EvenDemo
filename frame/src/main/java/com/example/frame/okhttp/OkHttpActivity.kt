package com.example.frame.okhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.frame.R
import kotlinx.android.synthetic.main.activity_ok_http.*
import okhttp3.*
import java.io.File
import java.io.IOException

class OkHttpActivity : AppCompatActivity() {
    private val okHttpClient =
        OkHttpClient
            .Builder()
            .cache(Cache(File("test"), 1024))
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)


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