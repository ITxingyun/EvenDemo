package com.xingyun.evendemo.view.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.xingyun.evendemo.R;


public class CircleImageView extends AppCompatImageView {
    public static final int TYPE_NONE = 0;
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_ROUNDED_RECT = 2;

    private static final int DEFAULT_TYPE = TYPE_NONE;
    private static final int DEFAULT_BORDER_COLOR = Color.TRANSPARENT;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_RECT_ROUND_RADIUS = 0;

    private final Paint mPaintBitmap = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mPaintBorder = new Paint(Paint.ANTI_ALIAS_FLAG);

    private final RectF mRectBorder = new RectF();
    private final RectF mRectBitmap = new RectF();

    private Bitmap mRawBitmap;
    private BitmapShader mShader;
    private final Matrix mMatrix = new Matrix();

    private int mType;
    private int mBorderColor;
    private int mBorderWidth;
    private int mRectRoundRadius;

    public CircleImageView(Context context) {
        super(context);
        init(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);
        mType = typedArray.getInt(R.styleable.CircleImageView_type, DEFAULT_TYPE);
        mBorderColor = typedArray.getColor(R.styleable.CircleImageView_borderColor, DEFAULT_BORDER_COLOR);
        mBorderWidth = typedArray.getDimensionPixelSize(R.styleable.CircleImageView_borderWidth, DEFAULT_BORDER_WIDTH);
        mRectRoundRadius = typedArray.getDimensionPixelSize(R.styleable.CircleImageView_rectRoundRadius, DEFAULT_RECT_ROUND_RADIUS);
        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap rawBitmap = getBitmap(getDrawable());
        if (rawBitmap != null && mType != TYPE_NONE) {
            int viewWidth = getWidth();
            int viewHeight = getHeight();
            int viewMinSize = Math.min(viewWidth, viewHeight);
            float dstWidth = mType == TYPE_CIRCLE ? viewMinSize : viewWidth;
            float dstHeight = mType == TYPE_CIRCLE ? viewMinSize : viewHeight;
            float halfBorderWidth = mBorderWidth / 2.0f;
            float doubleBorderWidth = mBorderWidth * 2;

            if (mShader == null || !rawBitmap.equals(mRawBitmap)) {
                mRawBitmap = rawBitmap;
                mShader = new BitmapShader(mRawBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            mMatrix.setScale((dstWidth - doubleBorderWidth) / rawBitmap.getWidth(), (dstHeight - doubleBorderWidth) / rawBitmap.getHeight());
            mShader.setLocalMatrix(mMatrix);

            mPaintBitmap.setShader(mShader);
            mPaintBorder.setStyle(Paint.Style.STROKE);
            mPaintBorder.setStrokeWidth(mBorderWidth);
            mPaintBorder.setColor(mBorderWidth > 0 ? mBorderColor : Color.TRANSPARENT);

            if (mType == TYPE_CIRCLE) {
                float radius = viewMinSize / 2.0f;
                canvas.drawCircle(radius, radius, radius - halfBorderWidth, mPaintBorder);
                canvas.translate(mBorderWidth, mBorderWidth);
                canvas.drawCircle(radius - mBorderWidth, radius - mBorderWidth, radius - mBorderWidth, mPaintBitmap);
            } else if (mType == TYPE_ROUNDED_RECT) {
                mRectBorder.set(halfBorderWidth, halfBorderWidth, dstWidth - halfBorderWidth, dstHeight - halfBorderWidth);
                mRectBitmap.set(0.0f, 0.0f, dstWidth - doubleBorderWidth, dstHeight - doubleBorderWidth);
                float borderRadius = Math.max(mRectRoundRadius - halfBorderWidth, 0.0f);
                float bitmapRadius = mRectRoundRadius - mBorderWidth > 0.0f ? mRectRoundRadius - mBorderWidth : 0.0f;
                canvas.drawRoundRect(mRectBorder, borderRadius, borderRadius, mPaintBorder);
                canvas.translate(mBorderWidth, mBorderWidth);
                canvas.drawRoundRect(mRectBitmap, bitmapRadius, bitmapRadius, mPaintBitmap);
            }
        } else {
            super.onDraw(canvas);
        }
    }

    private Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof ColorDrawable) {
            Rect rect = drawable.getBounds();
            int width = rect.right - rect.left;
            int height = rect.bottom - rect.top;
            int color = ((ColorDrawable) drawable).getColor();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
            return bitmap;
        } else {
            return null;
        }
    }
}
