package com.xingyun.evendemo.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.mvvm.EventObserver

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomeFragment(), false)
        initViewModel()
    }

    private fun initViewModel() {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
            .also { viewModel = it }
            .run {
                addFragment.observe(this@MainActivity, EventObserver {
                    addFragment(it)
                })

                replaceFragment.observe(this@MainActivity, EventObserver {
                    replaceFragment(it)
                })
            }
    }

    private fun addFragment(fragment: BaseFragment, isAddToBackStack: Boolean = true) {
        supportFragmentManager.beginTransaction()
            .apply {
                if (isAddToBackStack) {
                    addToBackStack(fragment.getFragmentTag())
                }
                add(R.id.fragment_container, fragment, fragment.getFragmentTag())
            }
            .commitAllowingStateLoss()
    }

    private fun replaceFragment(fragment: BaseFragment, isAddToBackStack: Boolean = true) =
        supportFragmentManager.beginTransaction()
            .apply {
                if (isAddToBackStack) {
                    addToBackStack(fragment.getFragmentTag())
                }
                replace(R.id.fragment_container, fragment, fragment.getFragmentTag())
            }
            .commitAllowingStateLoss()

}
