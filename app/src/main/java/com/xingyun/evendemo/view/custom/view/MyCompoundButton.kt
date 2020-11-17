package com.xingyun.evendemo.view.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.CompoundButton

/**
 * 拦截toggle
 */
class MyCompoundButton : CompoundButton {
    private var onTouchInterceptListener: OnTouchInterceptListener? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return onTouchInterceptListener?.intercept() ?: super.onTouchEvent(event)
    }


    fun setOnTouchInterceptListener(onTouchInterceptListener: OnTouchInterceptListener) {
        this.onTouchInterceptListener = onTouchInterceptListener
    }


    interface OnTouchInterceptListener {
        fun intercept(): Boolean
    }

}