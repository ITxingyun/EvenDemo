package com.xingyun.evendemo.view.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.xingyun.evendemo.R;


/**
 * @author chenyiwen2
 * date: 2020/10/28
 * 文本居中：https://blog.csdn.net/kong_gu_you_lan/article/details/78927930
 */
public class OvalLabelView extends View {
    private static final int DEFAULT_COLOR = 0;
    private int mOvalLabelBackground;
    private int mOvalTextColor;
    private Paint mPaint;
    private RectF mRectF;
    private String mLabel;

    public OvalLabelView(Context context) {
        super(context);
    }

    public OvalLabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public OvalLabelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.OvalLabelView);
        mLabel = typeArray.getString(R.styleable.OvalLabelView_label);
        mOvalTextColor = typeArray.getColor(R.styleable.OvalLabelView_labelColor, DEFAULT_COLOR);
        mOvalLabelBackground = typeArray.getColor(R.styleable.OvalLabelView_ovalLabelBackground, DEFAULT_COLOR);
        int labelSize = typeArray.getDimensionPixelSize(R.styleable.OvalLabelView_labelSize, 10);
        mPaint = new Paint();
        mPaint.setTextSize(labelSize);
        mRectF = new RectF();
        typeArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制椭圆
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mOvalLabelBackground);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        mRectF.set(getPaddingStart(), getPaddingTop(), width - getPaddingEnd(), height - getPaddingBottom());
        canvas.drawOval(mRectF, mPaint);

        if (mLabel == null) return;

        //把字体画到椭圆中间
        float baseLineY = +Math.abs(mPaint.ascent() + mPaint.descent()) / 2;
        canvas.translate(width / 2f, height / 2f);
        float textWidth = mPaint.measureText(mLabel);
        mPaint.setColor(mOvalTextColor);
        canvas.drawText(mLabel, -textWidth / 2, baseLineY, mPaint);
    }
}
