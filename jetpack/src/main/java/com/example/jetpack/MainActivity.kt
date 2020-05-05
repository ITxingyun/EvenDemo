package com.example.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpack.lifecycle.HomeFragment
import com.example.jetpack.lifecycle.MyLifecycleObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyLifecycleObserver("MainActivity"))
        supportFragmentManager.beginTransaction()
            .add(HomeFragment(), "HomeFragment")
            .commit()

        tv_text.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
