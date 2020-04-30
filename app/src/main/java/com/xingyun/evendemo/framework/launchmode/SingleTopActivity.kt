package com.xingyun.evendemo.framework.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseActivity
import com.xingyun.evendemo.databinding.ActivitySingaleTopBinding

class SingleTopActivity : BaseActivity() {
    private lateinit var binding: ActivitySingaleTopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_singale_top)
        binding.btnSingleInstance.setOnClickListener {
            startActivity(Intent(this@SingleTopActivity, SingleInstanceActivity::class.java))
        }
        binding.btnSingleTask.setOnClickListener {
            startActivity(Intent(this@SingleTopActivity, SingleTaskActivity::class.java))
        }
        binding.btnSingleTop.setOnClickListener {
            startActivity(Intent(this@SingleTopActivity, SingleTopActivity::class.java))
        }
        binding.btnStandard.setOnClickListener {
            startActivity(Intent(this@SingleTopActivity, StandardActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(tag, "onNewIntent")
    }
}