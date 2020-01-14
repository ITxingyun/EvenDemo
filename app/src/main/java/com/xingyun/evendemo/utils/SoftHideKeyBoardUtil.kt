package com.xingyun.evendemo.utils

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.widget.FrameLayout

class SoftHideKeyBoardUtil(act: Activity) {
    private var usableHeightPrevious: Int = 0
    private val content: FrameLayout = act.findViewById(android.R.id.content)
    private var childOfContent: View = content.getChildAt(0)
    private val frameLayoutParams: FrameLayout.LayoutParams
    private val contentHeight: Int = childOfContent.height
    private val usableHeightSansKeyboard = childOfContent.rootView.height

    init {
        childOfContent = content.getChildAt(0)
        frameLayoutParams = childOfContent.layoutParams as FrameLayout.LayoutParams
        childOfContent.viewTreeObserver.addOnGlobalLayoutListener {
            possiblyResizeChildOfContent()
        }
    }

    private fun possiblyResizeChildOfContent() {
        val r = Rect()
        childOfContent.getWindowVisibleDisplayFrame(r)
        val statusBarHeight = r.top
        val usableHeightNow = r.bottom - r.top
        if (usableHeightNow != usableHeightPrevious) {
            val heightDifference = usableHeightSansKeyboard - usableHeightNow
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference + statusBarHeight
            } else {
                frameLayoutParams.height = contentHeight
            }
            childOfContent.requestLayout()
            usableHeightPrevious = usableHeightNow
        }
    }

}