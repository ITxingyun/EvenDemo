package com.xingyun.evendemo.view.recyclerview.adapter

import android.content.res.Resources
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.xingyun.evendemo.R
import com.xingyun.library.base.BaseAdapter
import com.xingyun.library.base.BaseViewHolder
import com.xingyun.evendemo.databinding.ItemCacheTestBinding

class CacheTestAdapter(private val listener: OnClickListener): BaseAdapter<ItemCacheTestBinding>() {


    override fun getLayoutRes(): Int = R.layout.item_cache_test

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemCacheTestBinding> {
        Log.e("RecyclerView","onCreate()")
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBind(viewDataBinding: ItemCacheTestBinding, position: Int) {
        viewDataBinding.text = "position: $position"
        viewDataBinding.listener = listener
        Log.e("RecyclerView","onBind: $position")
    }

    override fun getItemCount(): Int = 50


    class DivideDecorator(resources: Resources): RecyclerView.ItemDecoration() {
        private val divide = resources.getDimensionPixelSize(R.dimen.dp_5)

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.set(divide, 0, divide, divide)
        }

    }

    interface OnClickListener {
        fun onClicked(text: String, view: ImageView)
    }
}