package com.xingyun.frame.retrofit

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xingyun.frame.BaseActivity
import com.xingyun.frame.R

@Route(path = "/test/activity")
class RetrofitActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
    }
}