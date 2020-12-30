package com.xingyun.evendemo.view.textview

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * 可以实现绝大部分需求，但是需要代码设置
 */
class CustomSpannableStringBuilder : SpannableStringBuilder() {


    fun addString(string: String): CustomSpannableStringBuilder {
        append(string)
        return this
    }

    fun addImage(context: Context, @DrawableRes drawableRes: Int, @DimenRes width: Int, @DimenRes height: Int): CustomSpannableStringBuilder {
        val len = length
        append(TAG_PLACEHOLDER)
        val drawable = ContextCompat.getDrawable(context, drawableRes)
        drawable?.let {
            it.setBounds(0, 0, width, height)
            setSpan(ImageSpan(it, ImageSpan.ALIGN_BASELINE), len, length, SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return this
    }


    private companion object {
        const val TAG_PLACEHOLDER = "\uFFFC"
    }

}