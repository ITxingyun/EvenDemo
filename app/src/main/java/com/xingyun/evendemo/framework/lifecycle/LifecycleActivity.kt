package com.xingyun.evendemo.framework.lifecycle

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseActivity
import com.xingyun.evendemo.databinding.ActivityLifecycleBinding

class LifecycleActivity: BaseActivity() {
    private lateinit var binding: ActivityLifecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lifecycle)
    }
}