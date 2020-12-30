package com.xingyun.evendemo.view.textview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * 多行中间省略号
 * desc:有问题，中英数字混合的字符串，就有问题了
 */
public class MiddleMultilineTextView extends AppCompatTextView {

    private static final  String SYMBOL = "...";
    private static final int SYMBOL_LENGTH = SYMBOL.length();

    public MiddleMultilineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int maxLine = getMaxLines();
        if (maxLine != Integer.MAX_VALUE && maxLine > 1) {
            int originalLength = getText().length();
            int visibleLength = getLayout().getLineEnd(getMaxLines() - 1);

            if (originalLength > visibleLength) {
                setText(smartTrim(getText().toString(), visibleLength));
            }
        }
    }

    private String smartTrim(String string, int visibleLength) {
        int realContentLength = visibleLength - SYMBOL_LENGTH;
        int leftStringLength = (int) Math.ceil(realContentLength >> 1);
        int rightStringLength = realContentLength - leftStringLength;
        return string.substring(0, leftStringLength) + SYMBOL + string.substring(string.length() - rightStringLength);
    }
}