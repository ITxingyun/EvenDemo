package com.example.dagger1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger1.bean.FileInfo
import com.example.dagger1.di.DaggerApplicationComponent
import com.example.dagger1.di.DaggerUserComponent
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fileInfo: FileInfo

    @Inject
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        DaggerApplicationComponent.create().inject(this)

        DaggerUserComponent.builder()
            .applicationComponent(DaggerApplicationComponent.create())
            .build()
            .inject(this)
        println("fileInfo=$fileInfo")
        println("retrofit=$retrofit")

        findViewById<TextView>(R.id.tv_start_to_second_activity).setOnClickListener {
            startToSecondActivity()
        }
    }

    private fun startToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}