package com.xingyun.evendemo.view.recyclerview.adapter

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xingyun.evendemo.R

class DivideDecorator(resources: Resources): RecyclerView.ItemDecoration() {
    private val divide = resources.getDimensionPixelSize(R.dimen.dp_5)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(divide, 0, divide, divide)
    }

}