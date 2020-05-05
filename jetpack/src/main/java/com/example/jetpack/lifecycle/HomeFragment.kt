package com.example.jetpack.lifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment

class HomeFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyLifecycleObserver("HomeFragment"))
    }

}