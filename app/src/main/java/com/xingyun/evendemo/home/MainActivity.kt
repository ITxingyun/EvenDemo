package com.xingyun.evendemo.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.R
import com.xingyun.library.base.BaseActivity
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.ActivityMainBinding
import com.xingyun.library.mvvm.EventObserver

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply { lifecycleOwner = this@MainActivity }.also { binding = it }

        if (savedInstanceState == null) {
            addFragment(HomeFragment(), false)
        }
        initViewModel()
    }

    private fun initViewModel() {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
            .also {
                viewModel = it
                binding.viewModel = it
            }
            .run {
                title.observe(this@MainActivity, Observer {
                    supportActionBar?.setTitle(it)
                })

                titleString.observe(this@MainActivity, Observer {
                    supportActionBar?.title = it
                })

                addFragment.observe(this@MainActivity,
                    EventObserver {
                        addFragment(it)
                    })

                replaceFragment.observe(this@MainActivity,
                    EventObserver {
                        replaceFragment(it)
                    })

                backToPreviousPage.observe(this@MainActivity,
                    EventObserver {
                        onBackPressed()
                    })
            }
        setSupportActionBar(binding.toolbar)
    }

    private fun addFragment(fragment: BaseFragment, isAddToBackStack: Boolean = true) {
        supportFragmentManager.beginTransaction()
            .apply {
                if (isAddToBackStack) {
                    addToBackStack(fragment.toolbarTitle)
                }
                add(R.id.fragment_container, fragment, fragment.toolbarTitle)
            }
            .commitAllowingStateLoss()
    }

    private fun replaceFragment(fragment: BaseFragment, isAddToBackStack: Boolean = true) =
        supportFragmentManager.beginTransaction()
            .apply {
                if (isAddToBackStack) {
                    addToBackStack(fragment.toolbarTitle)
                }
                replace(R.id.fragment_container, fragment, fragment.toolbarTitle)
            }
            .commitAllowingStateLoss()


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val fragments = supportFragmentManager.fragments
        fragments.forEach {
            it.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

}
