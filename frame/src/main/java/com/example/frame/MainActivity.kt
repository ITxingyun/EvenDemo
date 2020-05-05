package com.example.frame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.frame.eventbus.MessageEvent
import com.example.frame.eventbus.EventBusActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_start.setOnClickListener {
            Thread(Runnable {
                EventBus.getDefault().postSticky(MessageEvent("xingyun"))
            }).start()
            startActivity(Intent(this, EventBusActivity::class.java))
        }
    }
}
