package com.xingyun.evendemo.framework.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseActivity
import com.xingyun.evendemo.databinding.ActivitySingaleTaskBinding

class SingleTaskActivity : BaseActivity() {
    private lateinit var binding: ActivitySingaleTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_singale_task)
        binding.btnSingleInstance.setOnClickListener {
            startActivity(Intent(this@SingleTaskActivity, SingleInstanceActivity::class.java))
        }
        binding.btnSingleTask.setOnClickListener {
            startActivity(Intent(this@SingleTaskActivity, SingleTaskActivity::class.java))
        }
        binding.btnSingleTop.setOnClickListener {
            startActivity(Intent(this@SingleTaskActivity, SingleTopActivity::class.java))
        }
        binding.btnStandard.setOnClickListener {
            startActivity(Intent(this@SingleTaskActivity, StandardActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(tag, "onNewIntent")
    }
}