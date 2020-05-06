package com.xingyun.evendemo.view.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.R

class FilterFlowGroup : ViewGroup {
    private var itemSpacing = 0
    private var lineSpacing = 0
    private var lineCount = 1
    private var expandLine = 0

    private var adapter : FilterFlowAdapter? = null

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
            expandLine = array.getInt(R.styleable.FilterFlowGroup_expandLine, 2)
            array.recycle()
        }

    }

    fun setAdapter(adapter: FilterFlowAdapter) {
        this.adapter = adapter

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        adapter?.run {
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

            val itemCount = getItemCount()
            val expandView = getExpandView(this@FilterFlowGroup)
            val clearAllView = getClearAllView(this@FilterFlowGroup)
            measureChild(expandView, widthMeasureSpec, heightMeasureSpec)
            measureChild(clearAllView, widthMeasureSpec, heightMeasureSpec)

            for (i in 0 until itemCount) {
                val child = getView(i, this@FilterFlowGroup)
                if (child.visibility == View.GONE) {
                    continue
                }
                measureChild(child, widthMeasureSpec, heightMeasureSpec)
                childRight = childLeft + child.measuredWidth

                if (!hasExpanded && lineCount == expandLine) {
                    val expandViewWidth = expandView.measuredWidth + itemSpacing + clearAllView.measuredWidth
                    if (maxRight - expandViewWidth < childRight) {
                        maxChildRight += expandViewWidth
                        lineCount = 1
                        expandViewPosition = i
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

            maxChildRight += paddingRight
            childBottom += paddingBottom

            val finalWidth = getMeasuredDimension(width, widthMode, maxChildRight)
            val finalHeight = getMeasuredDimension(height, heightMode, childBottom)
            setMeasuredDimension(finalWidth, finalHeight)
        }
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
        var childEnd: Int

        val maxChildEnd = right - left - paddingEnd

        for (i in 0 until childCount) {
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
    }

}