package com.xingyun.evendemo.common.adapter

import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.ItemProjectBinding
import com.xingyun.library.base.BaseAdapter

class ProjectAdapter(
    private val fragments: List<BaseFragment>,
    private val onViewItemClickListener: OnViewItemClickListener
) : BaseAdapter<BaseFragment, ItemProjectBinding>() {


    override fun getLayoutRes(): Int = R.layout.item_project

    override fun onDataBindingCreated(viewDataBinding: ItemProjectBinding) {
        viewDataBinding.listener = onViewItemClickListener
    }

    override fun onBind(viewDataBinding: ItemProjectBinding, position: Int) {
        viewDataBinding.fragment = fragments[position]
    }

    override fun getItemCount(): Int = fragments.size

    interface OnViewItemClickListener {
        fun onItemClick(fragment: BaseFragment)
    }

}