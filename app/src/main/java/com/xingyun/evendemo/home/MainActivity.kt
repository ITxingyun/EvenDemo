package com.xingyun.evendemo.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomeFragment())
    }

    private fun addFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment, fragment.getFragmentTag())
            .commit()
    }

    fun replaceFragment(fragment: BaseFragment) =
            supportFragmentManager.beginTransaction()
                    .addToBackStack("even_demo")
                    .replace(R.id.fragment_container, fragment, fragment.getFragmentTag())
                    .commit()

}
