package com.xingyun.evendemo.viewpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.BR
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseAdapter
import com.xingyun.evendemo.databinding.ItemViewPageBinding

class SimplePageAdapter(private val pages: List<String>) : BaseAdapter<ItemViewPageBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_view_page

    override fun onCreateView(inflater: LayoutInflater, layoutId: Int, parent: ViewGroup, attachToParent: Boolean): ItemViewPageBinding =
            DataBindingUtil.inflate(inflater, layoutId, parent, attachToParent)

    override fun onBind(viewDataBinding: ItemViewPageBinding, position: Int) {
        viewDataBinding.setVariable(BR.page, pages[position])
    }

    override fun getItemCount(): Int = pages.size


}