package com.xingyun.evendemo.view.recyclerview.adapter

import com.xingyun.evendemo.R
import com.xingyun.library.base.BaseAdapter
import com.xingyun.evendemo.databinding.ItemSimpleTextBinding

open class SimpleTextAdapter: BaseAdapter<String, ItemSimpleTextBinding>() {
    override fun getLayoutRes(): Int = R.layout.item_simple_text

    override fun onBind(viewDataBinding: ItemSimpleTextBinding, position: Int) {
        viewDataBinding.text = data[position]
        viewDataBinding.position = position + 1
    }

    override fun getItemCount(): Int = data.size

}