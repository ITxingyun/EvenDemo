package com.example.dagger1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger1.bean.People
import com.example.dagger1.di.DaggerApplicationComponent
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var people: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        DaggerApplicationComponent.builder()
            .build()
            .factory()
            .create()
            .inject(this)

        println("people = $people")
    }


}