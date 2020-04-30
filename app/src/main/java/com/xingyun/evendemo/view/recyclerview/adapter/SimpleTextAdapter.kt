package com.xingyun.evendemo.view.recyclerview.adapter

import com.xingyun.evendemo.R
import com.xingyun.library.base.adapter.BaseAdapter
import com.xingyun.evendemo.databinding.ItemSimpleTextBinding

class SimpleTextAdapter(private val data: List<String>): BaseAdapter<ItemSimpleTextBinding>() {
    override fun getLayoutRes(): Int = R.layout.item_simple_text

    override fun onBind(viewDataBinding: ItemSimpleTextBinding, position: Int) {
        viewDataBinding.text = data[position]
    }

    override fun getItemCount(): Int = data.size

}