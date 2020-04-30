package com.xingyun.evendemo.framework.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseActivity
import com.xingyun.evendemo.databinding.ActivitySingaleInstanceBinding

class SingleInstanceActivity : BaseActivity() {
    private lateinit var binding: ActivitySingaleInstanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_singale_instance)
        binding.btnSingleInstance.setOnClickListener {
            startActivity(Intent(this@SingleInstanceActivity, SingleInstanceActivity::class.java))
        }
        binding.btnSingleTask.setOnClickListener {
            startActivity(Intent(this@SingleInstanceActivity, SingleTaskActivity::class.java))
        }
        binding.btnSingleTop.setOnClickListener {
            startActivity(Intent(this@SingleInstanceActivity, SingleTopActivity::class.java))
        }
        binding.btnStandard.setOnClickListener {
            startActivity(Intent(this@SingleInstanceActivity, StandardActivity::class.java))
        }


    }

}