package com.xingyun.android.web

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xingyun.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
    }

}