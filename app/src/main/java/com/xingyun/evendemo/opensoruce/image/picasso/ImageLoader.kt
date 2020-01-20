package com.xingyun.evendemo.opensoruce.image.picasso

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader {



    companion object {
        const val PICASSO_CACHE = "xingyun-picasso-cache"

        fun loadImage(imageView: ImageView, url: String) =
            Picasso.get().load(url).into(imageView)

        fun loadImage(imageView: ImageView, url: String, placeholder: Int) =
            Picasso.get().load(url).placeholder(placeholder).into(imageView)
    }
}