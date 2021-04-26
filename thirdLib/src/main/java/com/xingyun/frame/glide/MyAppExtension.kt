package com.xingyun.frame.glide

import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions.decodeTypeOf


@GlideExtension
class MyAppExtension private constructor(){

    companion object {

        private const val  MINI_THUMB_SIZE = 100
        private val DECODE_TYPE_GIF = decodeTypeOf(GifDrawable::class.java).lock()

        @JvmStatic
        @GlideOption
        fun  miniThumb(options: BaseRequestOptions<*>): BaseRequestOptions<*> =
            options.fitCenter().override(MINI_THUMB_SIZE)

        @JvmStatic
        @GlideType(GifDrawable::class)
        fun asCustomGif(requestBuilder: RequestBuilder<GifDrawable>): RequestBuilder<GifDrawable> {
            return requestBuilder
                .transition(DrawableTransitionOptions())
                .apply(DECODE_TYPE_GIF)
        }
    }
}