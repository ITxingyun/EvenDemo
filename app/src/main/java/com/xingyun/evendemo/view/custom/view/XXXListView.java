package com.xingyun.evendemo.view.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.xingyun.evendemo.R;

import java.util.List;

public class XXXListView extends ViewGroup {

    private TextView mTvMore;
    private int itemSpace = 20;

    public XXXListView(Context context) {
        this(context, null);
    }

    public XXXListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XXXListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTvMore = generateItem("...");
        addView(mTvMore);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int paddingEnd = getPaddingEnd();
        int childStart = getPaddingStart();
        int childEnd;
        int maxChildEnd = right - paddingEnd - mTvMore.getMeasuredWidth() - itemSpace;

        int childTop = getPaddingTop();

        int itemCount = getChildCount();
        for (int index = 1; index < itemCount; index++) {
            View child = getChildAt(index);
            if (child.getVisibility() == View.GONE) {
                continue;
            }
            childEnd = childStart + child.getMeasuredWidth();
            if (childEnd < maxChildEnd) {
                child.layout(childStart, childTop, childEnd, childTop + child.getMeasuredHeight());
            } else {
                mTvMore.layout(childStart, childTop, childStart + mTvMore.getMeasuredWidth(), childTop + mTvMore.getMeasuredHeight());
                break;
            }
            childStart = childEnd + itemSpace;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int realWidth;
        if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.EXACTLY) {
            realWidth = width;
        } else {
            realWidth = Integer.MAX_VALUE;
        }

        int childStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();

        measureChild(mTvMore, widthMeasureSpec, heightMeasureSpec);

        int maxChildEnd = realWidth - paddingEnd - mTvMore.getMeasuredWidth() - itemSpace;
        int itemCount = getChildCount();
        int childEnd;
        for (int index = 1; index < itemCount; index++) {
            View child = getChildAt(index);
            if (child.getVisibility() == View.GONE) {
                continue;
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            childEnd = childStart + child.getMeasuredWidth();
            if (childEnd > maxChildEnd) {
                break;
            }
            childStart = childEnd + itemSpace;
        }
        setMeasuredDimension(realWidth, height);
    }


    public TextView generateItem(String text) {
        TextView textView  = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.xx_list_item, null);
        textView.setText(text);
        return textView;
    }

    public void addTag(List<String> tags) {
        for (String tag : tags) {
            addView(generateItem(tag));
        }
        requestLayout();
    }
}
