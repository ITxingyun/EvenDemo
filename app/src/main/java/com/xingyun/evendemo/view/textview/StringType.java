package com.xingyun.evendemo.view.textview;

public class StringType {
    @Typo
    private int type;
    private int imageOrStringRes;

    public StringType(@Typo int type, int imageOrStringRes) {
        this.type = type;
        this.imageOrStringRes = imageOrStringRes;
    }

    public int getType() {
        return type;
    }

    public int getImageOrStringRes() {
        return imageOrStringRes;
    }

    public @interface Typo {
        int TYPE_IMAGE = 1;
        int TYPE_STRING = 2;
    }
}
