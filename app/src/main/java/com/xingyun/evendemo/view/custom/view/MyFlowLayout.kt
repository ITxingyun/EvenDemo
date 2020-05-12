package com.xingyun.evendemo.view.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ItemFliterOptionBinding
import com.xingyun.evendemo.databinding.LayoutClearAllViewBinding
import com.xingyun.evendemo.databinding.LayoutExpandBinding

class MyFlowLayout : ViewGroup {
    private var itemSpacing = 0
    private var lineSpacing = 0
    private var expandLine = 0

    var hasExpanded = false
    var expandViewPosition = 0

    lateinit var expandView: View
    lateinit var clearAllView: View

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
            val array = context.obtainStyledAttributes(it, R.styleable.MyFlowLayout, 0, 0)
            itemSpacing = array.getDimensionPixelSize(R.styleable.MyFlowLayout_itemSpacing, 0)
            lineSpacing = array.getDimensionPixelSize(R.styleable.MyFlowLayout_lineSpacing, 0)
            expandLine = array.getInt(R.styleable.MyFlowLayout_expandLine, 2)
            array.recycle()
        }

        expandView = LayoutExpandBinding.inflate(LayoutInflater.from(context), this, true).root
        clearAllView = LayoutClearAllViewBinding.inflate(LayoutInflater.from(context), this, true).root

        expandView.setOnClickListener {
            hasExpanded = !hasExpanded
            updateUIAfterExpand()
        }

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
        var childRight = 0
        var maxChildRight = 0
        val maxRight = maxWidth - paddingRight
        var lineCount = 1

        measureChild(expandView, widthMeasureSpec, heightMeasureSpec)
        measureChild(clearAllView, widthMeasureSpec, heightMeasureSpec)

        val expandViewWidth = expandView.measuredWidth + itemSpacing + clearAllView.measuredWidth

        for (i in 2 until childCount) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) {
                continue
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            childRight = childLeft + child.measuredWidth

            if (!hasExpanded && lineCount == expandLine) {
                if (childRight + expandViewWidth > maxRight) {
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

        if (hasExpanded && childRight + expandViewWidth + itemSpacing > maxRight) {
            childBottom += expandView.measuredHeight + lineSpacing
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
        var childEnd: Int

        val maxChildEnd = right - left - paddingEnd

        val itemCount = if (hasExpanded) childCount else expandViewPosition
        for (i in 2 until itemCount) {
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

        childEnd = childStart + expandView.measuredWidth
        if (childEnd > maxChildEnd) {
            childStart = paddingStart
            childTop = childBottom + lineSpacing
        }
        childEnd = childStart + expandView.measuredWidth
        childBottom = childTop + expandView.measuredHeight
        expandView.layout(childStart, childTop, childEnd, childBottom)
        childStart += expandView.measuredWidth + itemSpacing

        childEnd = childStart + clearAllView.measuredWidth
        if (childEnd > maxChildEnd) {
            childStart = paddingStart
            childTop = childBottom + lineSpacing
        }
        childEnd = childStart + clearAllView.measuredWidth
        childBottom = childTop + expandView.measuredHeight
        clearAllView.layout(childStart, childTop, childEnd, childBottom)
    }

     private fun updateUIAfterExpand() {
        val startIndex = expandViewPosition
        for (index in startIndex until childCount) {
            getChildAt(index).visibility = if (hasExpanded) View.VISIBLE else View.GONE
        }
        requestLayout()
    }

    fun update(list: List<String>) {
        list.forEach {filterOption ->
            ItemFliterOptionBinding.inflate(LayoutInflater.from(context), this, true)
                    .apply {
                        text = filterOption
                    }
        }
        requestLayout()
    }

}