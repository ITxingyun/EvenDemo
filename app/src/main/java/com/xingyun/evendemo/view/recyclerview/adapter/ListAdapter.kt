package com.xingyun.evendemo.view.recyclerview.adapter

import android.widget.ImageView
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ItemFeatureBinding
import com.xingyun.library.base.BaseAdapter

class ListAdapter(private val listener: OnClickListener) : BaseAdapter<String, ItemFeatureBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_feature

    override fun onDataBindingCreated(viewDataBinding: ItemFeatureBinding) {
        viewDataBinding.listener = listener
    }

    override fun onBind(viewDataBinding: ItemFeatureBinding, position: Int) {
        viewDataBinding.text = data[position]
        viewDataBinding.position = position + 1
    }

    interface OnClickListener {
        fun onClicked(text: String, view: ImageView)

        fun onRemoved(text: String)
    }

    fun remove(text: String) {
        val index = data.indexOf(text)
        data.remove(text)
        notifyItemRemoved(index)
    }

    fun add(position: Int) {
        if (position > itemCount) {
            data.add("小美")
            notifyItemInserted(itemCount)
        } else {
            data.add(position, "小美")
            notifyItemInserted(position)
        }
    }
}