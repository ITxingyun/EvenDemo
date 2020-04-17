package com.xingyun.evendemo.view.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.ViewCompat
import com.google.android.material.chip.Chip
import com.xingyun.evendemo.R

class FilterFlowGroup : ViewGroup {
    private var itemSpacing = 0
    private var lineSpacing = 0
    private var lineCount = 1
    private var expandLine = 0

    private var isShowAllView = false
    private var visibleViewCount = 0
    private lateinit var moreView: Chip

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        attrs?.let {
            val array = context.obtainStyledAttributes(it, R.styleable.FilterFlowGroup, 0, 0)
            itemSpacing = array.getDimensionPixelSize(R.styleable.FilterFlowGroup_itemSpacing, 0)
            lineSpacing = array.getDimensionPixelSize(R.styleable.FilterFlowGroup_lineSpacing, 0)
            expandLine = array.getDimensionPixelSize(R.styleable.FilterFlowGroup_itemSpacing, 2)
            array.recycle()
        }
        moreView = Chip(context).apply {
            setBackgroundResource(R.color.white)
            setOnClickListener {
                isShowAllView = !isShowAllView
                requestLayout()
            }
        }

        addView(moreView)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        val height = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val maxWidth = if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.EXACTLY) width else Int.MAX_VALUE
        var childLeft = paddingLeft
        var childTop = paddingTop
        var childBottom = childTop
        var childRight: Int
        var maxChildRight = 0
        val maxRight = maxWidth - paddingRight

        measureChild(moreView, widthMeasureSpec, heightMeasureSpec)

        for (i in 1 until childCount) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) {
                continue
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            val lp = child.layoutParams
            var leftMargin = 0
            var rightMargin = 0
            if (lp is MarginLayoutParams) {
                leftMargin += lp.leftMargin
                rightMargin += lp.rightMargin
            }
            childRight = childLeft + leftMargin + child.measuredWidth


            if (!isShowAllView && lineCount == expandLine) {
                val moreViewWidth = getMoreViewWidth(childCount - i)
                if (maxRight - moreViewWidth < childRight) {
                    visibleViewCount = i
                    maxChildRight += moreViewWidth
                    lineCount = 1
                    break
                }
            }

            //child layout on next line
            if (childRight > maxRight) {
                childLeft = paddingLeft
                childTop = childBottom + lineSpacing
                lineCount++
            }

            childRight = childLeft + leftMargin + child.measuredWidth
            childBottom = childTop + child.measuredHeight

            // Updates max right bound if current child's right bound exceeds it.
            if (childRight > maxChildRight) {
                maxChildRight = childRight
            }

            childLeft += leftMargin + rightMargin + child.measuredWidth + itemSpacing

            if (i == childCount - 1) {
                maxChildRight += rightMargin
            }
        }

        maxChildRight += paddingRight
        childBottom += paddingBottom

        val finalWidth = getMeasuredDimension(width, widthMode, maxChildRight)
        val finalHeight = getMeasuredDimension(height, heightMode, childBottom)
        setMeasuredDimension(finalWidth, finalHeight)
    }

    private fun getMeasuredDimension(size: Int, mode: Int, childrenEdge: Int): Int {
        return when (mode) {
            MeasureSpec.EXACTLY -> size
            MeasureSpec.AT_MOST -> childrenEdge.coerceAtMost(size)
            else -> childrenEdge
        }
    }

    private fun getMoreViewWidth(hideCount: Int): Int {
        moreView.text = context.getString(R.string.registry_product_filter_option_more_view, hideCount)
        return moreView.measuredWidth
    }

    override fun onLayout(sizeChanged: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        val isRtl = ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL
        val paddingStart = if (isRtl) paddingRight else paddingLeft
        val paddingEnd = if (isRtl) paddingLeft else paddingRight
        var childStart = paddingStart
        var childTop = paddingTop
        var childBottom = childTop
        var childEnd: Int

        val maxChildEnd = right - left - paddingEnd

        val shouldLayoutChildCount = if (isShowAllView) childCount else visibleViewCount

        for (i in 1 until shouldLayoutChildCount) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) {
                continue
            }
            val lp = child.layoutParams
            var startMargin = 0
            var endMargin = 0
            if (lp is MarginLayoutParams) {
                startMargin = MarginLayoutParamsCompat.getMarginStart(lp)
                endMargin = MarginLayoutParamsCompat.getMarginEnd(lp)
            }
            childEnd = childStart + startMargin + child.measuredWidth
            if (childEnd > maxChildEnd) {
                childStart = paddingStart
                childTop = childBottom + lineSpacing
            }
            childEnd = childStart + startMargin + child.measuredWidth
            childBottom = childTop + child.measuredHeight

            if (isRtl) {
                child.layout(maxChildEnd - childEnd, childTop, maxChildEnd - childStart - startMargin, childBottom)
            } else {
                child.layout(childStart + startMargin, childTop, childEnd, childBottom)
            }
            childStart += startMargin + endMargin + child.measuredWidth + itemSpacing
        }

        if (!isShowAllView && visibleViewCount < childCount) {
            moreView.layout(childStart, childTop, childStart + moreView.measuredWidth, childTop + moreView.measuredHeight)
        }
    }

}