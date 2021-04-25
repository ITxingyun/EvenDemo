package com.xingyun.evendemo.view.recyclerview.adapter

import android.util.Log
import android.widget.ImageView
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ItemCacheTestBinding
import com.xingyun.library.base.BaseAdapter

class CacheTestAdapter(private val listener: OnClickListener) : BaseAdapter<String, ItemCacheTestBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_cache_test

    override fun onBind(viewDataBinding: ItemCacheTestBinding, position: Int) {
        viewDataBinding.listener = listener
        viewDataBinding.text = data[position]
        viewDataBinding.position = position
        Log.e("RecyclerView", "onBind: $position")
    }

    interface OnClickListener {
        fun onClicked(text: String, view: ImageView)

        fun onRemoved(position: Int)
    }

    fun remove(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }
}