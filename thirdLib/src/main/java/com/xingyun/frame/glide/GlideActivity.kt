package com.xingyun.frame.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xingyun.frame.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        initImage()
    }

    private fun initImage() {
        GlideApp.with(this)
            .load(URL)
            .placeholder(R.drawable.bg_default)
            .error( GlideApp.with(this).load(URL))
            .fallback(R.drawable.bg_default)
            .into(iv_1)


    }



    companion object {
        const val URL = "https://static.xoedge.com/xo-registry/cashfunds/1_custom_fund.jpg"
    }

}