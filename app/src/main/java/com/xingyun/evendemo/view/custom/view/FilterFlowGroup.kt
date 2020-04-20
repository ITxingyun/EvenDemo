package com.xingyun.evendemo.view.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import com.google.android.material.chip.Chip
import com.xingyun.evendemo.R

class FilterFlowGroup : ViewGroup {
    private var itemSpacing = 0
    private var lineSpacing = 0
    private var lineCount = 1
    private var expandLine = 0

    private var hasShowAllView = false
    private var visibleViewCount = 0
    private lateinit var moreView: Chip
    private lateinit var clearText: AppCompatTextView
    private var childList = mutableListOf<View>()

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
            expandLine = array.getDimensionPixelSize(R.styleable.FilterFlowGroup_expandLine, 2)
            array.recycle()
        }
        moreView = Chip(context).apply {
            setBackgroundResource(R.color.white)
            setOnClickListener {
                this@FilterFlowGroup.lineCount = 1
                hasShowAllView = !hasShowAllView
                text = "See Less"
                relayout()
            }
            text = "See Less"
        }
        clearText = AppCompatTextView(context).apply {
            text = "clear all"
        }
        addView(moreView)
        addView(clearText)
    }

    private fun relayout() {
        requestLayout()
        invalidate()
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
        var expandViewWidth = 0

        measureChild(moreView, widthMeasureSpec, heightMeasureSpec)
        measureChild(clearText, widthMeasureSpec, heightMeasureSpec)

        for (i in 2 until childCount) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) {
                continue
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            childRight = childLeft + child.measuredWidth

            if (!hasShowAllView && lineCount == expandLine) {
                updateMoreViewText(i)
                measureChild(moreView, widthMeasureSpec, heightMeasureSpec)
                expandViewWidth = moreView.measuredWidth + itemSpacing + clearText.measuredWidth
                if (maxRight - expandViewWidth < childRight) {
                    visibleViewCount = i
                    maxChildRight += expandViewWidth
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

            childRight = childLeft + child.measuredWidth
            childBottom = childTop + child.measuredHeight

            // Updates max right bound if current child's right bound exceeds it.
            if (childRight > maxChildRight) {
                maxChildRight = childRight
            }

            childLeft += child.measuredWidth + itemSpacing
        }

        if (hasShowAllView) {
            maxChildRight += expandViewWidth
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

    override fun onLayout(sizeChanged: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        val paddingStart = paddingLeft
        val paddingEnd = paddingRight
        var childStart = paddingStart
        var childTop = paddingTop
        var childBottom = childTop
        var childEnd = 0

        val maxChildEnd = right - left - paddingEnd

        val shouldLayoutChildCount = if (hasShowAllView) childCount else visibleViewCount

        for (i in 2 until shouldLayoutChildCount) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) {
                continue
            }

            childEnd = childStart + child.measuredWidth
            if (childEnd > maxChildEnd) {
                childStart = paddingStart
                childTop = childBottom + lineSpacing
            }
            childEnd = childStart + child.measuredWidth
            childBottom = childTop + child.measuredHeight

            child.layout(childStart, childTop, childEnd, childBottom)
            childStart += child.measuredWidth + itemSpacing
        }

        if (hasShowAllView) {
            childEnd += moreView.measuredWidth
            if (childEnd > maxChildEnd) {
                childStart = paddingStart
                childTop = childBottom + lineSpacing
            }
            childEnd = childStart + moreView.measuredWidth + itemSpacing
            moreView.layout(childStart, childTop, childEnd, childBottom)
            childStart = childEnd + lineSpacing

            childEnd += clearText.measuredWidth
            if (childEnd > maxChildEnd) {
                childStart = paddingStart
                childTop = childBottom + lineSpacing
            }
            childEnd = childStart + clearText.measuredWidth
            clearText.layout(childStart, childTop, childEnd, childBottom)
        } else {
            moreView.layout(childStart, childTop, childStart + moreView.measuredWidth, childTop + moreView.measuredHeight)
            childStart += moreView.measuredWidth + itemSpacing
            clearText.layout(childStart, childTop, childStart + clearText.measuredWidth, childTop + moreView.measuredHeight)
        }
    }

    private fun updateMoreViewText(hideCount: Int) {
        moreView.text = context.getString(R.string.registry_product_filter_option_more_view, hideCount)
    }

}