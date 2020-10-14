package com.xingyun.jetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xingyun.jetpack.lifecycle.HomeFragment
import com.xingyun.jetpack.lifecycle.MyLifecycleObserver
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
