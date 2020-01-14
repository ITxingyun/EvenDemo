package com.xingyun.evendemo.image.picasso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.view.recyclerview.BaseAdapter
import com.xingyun.evendemo.databinding.ItemPicassoBinding

class PicassoAdapter(
    private val imageUrls: List<String>
) : BaseAdapter<ItemPicassoBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_picasso

    override fun onCreateView(
        inflater: LayoutInflater,
        layoutId: Int,
        parent: ViewGroup,
        attachToParent: Boolean
    ): ItemPicassoBinding =
        DataBindingUtil.inflate(inflater, layoutId, parent, attachToParent)

    override fun onBind(viewDataBinding: ItemPicassoBinding, position: Int) {
        ImageLoader.loadImage(viewDataBinding.ivPicasso, imageUrls[position], R.drawable.bg_yao)
    }

    override fun getItemCount(): Int = imageUrls.size

}