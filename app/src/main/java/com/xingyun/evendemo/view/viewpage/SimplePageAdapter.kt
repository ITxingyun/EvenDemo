package com.xingyun.evendemo.view.viewpage

import com.xingyun.evendemo.BR
import com.xingyun.evendemo.R
import com.xingyun.library.base.BaseAdapter
import com.xingyun.evendemo.databinding.ItemViewPageBinding

class SimplePageAdapter : BaseAdapter<String, ItemViewPageBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_view_page

    override fun onBind(viewDataBinding: ItemViewPageBinding, position: Int) {
        viewDataBinding.setVariable(BR.page, data[position])
    }

}