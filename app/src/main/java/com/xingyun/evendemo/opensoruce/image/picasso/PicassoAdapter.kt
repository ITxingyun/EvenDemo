package com.xingyun.evendemo.opensoruce.image.picasso

import com.xingyun.evendemo.R
import com.xingyun.library.base.adapter.BaseAdapter
import com.xingyun.evendemo.databinding.ItemPicassoBinding

class PicassoAdapter(
        private val imageUrls: List<String>
) : BaseAdapter<ItemPicassoBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_picasso

    override fun onBind(viewDataBinding: ItemPicassoBinding, position: Int) {
        ImageLoader.loadImage(viewDataBinding.ivPicasso, imageUrls[position], R.drawable.bg_yao)
    }

    override fun getItemCount(): Int = imageUrls.size

}