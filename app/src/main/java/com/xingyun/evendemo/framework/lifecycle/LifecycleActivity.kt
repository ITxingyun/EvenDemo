package com.xingyun.evendemo.framework.lifecycle

import android.os.Bundle
import android.os.PersistableBundle
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseActivity

class LifecycleActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_lifecycle)
    }
}