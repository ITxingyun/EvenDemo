package com.xingyun.evendemo.view.textview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

/**
 * 通过HTML实现字符串中间插入图片
 * 问题：无法控制图片的大小
 */
public class ImageTextView extends AppCompatTextView {
    public static final String STRING_FORMAT = "<img src='%s'>";

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setImageAndText(int imageWidth, int imageHeight, StringType... stringTypes) {
        setText(Html.fromHtml(getTextString(stringTypes),Html.FROM_HTML_MODE_LEGACY,  new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                int id = Integer.parseInt(source);
                Drawable drawable = ResourcesCompat.getDrawable(getResources(), id, null);
                drawable.setBounds(0, 0, imageWidth, imageHeight);
                return drawable;
            }
        }, null));
    }

    private String getTextString(StringType[] stringTypes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StringType stringType : stringTypes) {
            if (stringType.getType() == StringType.Typo.TYPE_STRING) {
                stringBuilder.append(getContext().getString(stringType.getImageOrStringRes()));
            } else if (stringType.getType() == StringType.Typo.TYPE_IMAGE) {
                stringBuilder.append(String.format(STRING_FORMAT, stringType.getImageOrStringRes()));
            }
        }
        return stringBuilder.toString();
    }



}
