package com.xingyun.frame.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xingyun.frame.R
import com.xingyun.frame.databinding.ActivityGlideBinding

class GlideActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        val binding = DataBindingUtil.setContentView<ActivityGlideBinding>(this, R.layout.activity_glide)
        initImage(binding)
    }

    private fun initImage(binding: ActivityGlideBinding) {
        GlideApp.with(this)
            .load(URL)
            .placeholder(R.drawable.bg_default)
            .error( GlideApp.with(this).load(URL))
            .fallback(R.drawable.bg_default)
            .into(binding.iv1)


    }



    companion object {
        const val URL = "https://static.xoedge.com/xo-registry/cashfunds/1_custom_fund.jpg"
    }

}