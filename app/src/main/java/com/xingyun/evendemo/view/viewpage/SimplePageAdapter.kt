package com.xingyun.evendemo.view.viewpage

import com.xingyun.evendemo.BR
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.adapter.BaseAdapter
import com.xingyun.evendemo.databinding.ItemViewPageBinding

class SimplePageAdapter(private val pages: List<String>) : BaseAdapter<ItemViewPageBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_view_page

    override fun onBind(viewDataBinding: ItemViewPageBinding, position: Int) {
        viewDataBinding.setVariable(BR.page, pages[position])
    }

    override fun getItemCount(): Int = pages.size


}