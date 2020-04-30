package com.xingyun.evendemo.framework.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseActivity
import com.xingyun.evendemo.databinding.ActivityStandardBinding

class StandardActivity : BaseActivity() {
    private lateinit var binding: ActivityStandardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_standard)
        binding.btnSingleInstance.setOnClickListener {
            startActivity(Intent(this@StandardActivity, SingleInstanceActivity::class.java))
        }
        binding.btnSingleTask.setOnClickListener {
            startActivity(Intent(this@StandardActivity, SingleTaskActivity::class.java))
        }
        binding.btnSingleTop.setOnClickListener {
            startActivity(Intent(this@StandardActivity, SingleTopActivity::class.java))
        }
        binding.btnStandard.setOnClickListener {
//            startActivity(Intent(this@StandardActivity, StandardActivity::class.java))
            val intent = Intent()
            intent.action = "com.xingyun.android"
//            intent.data = Uri.parse("http://www.google.com:8080/search/info")
            startActivity(intent)
        }
    }
}