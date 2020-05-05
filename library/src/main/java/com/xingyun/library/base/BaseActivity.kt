package com.xingyun.library.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    protected open val tag = javaClass.simpleName



}