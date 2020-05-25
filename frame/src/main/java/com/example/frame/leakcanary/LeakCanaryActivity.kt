package com.example.frame.leakcanary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.frame.R

class LeakCanaryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_canary)
    }
}