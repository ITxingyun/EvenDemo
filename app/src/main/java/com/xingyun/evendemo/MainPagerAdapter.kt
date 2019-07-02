package com.xingyun.evendemo

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xingyun.evendemo.databinding.ItemMainPagerBinding
import com.xingyun.evendemo.livedata.BaseAdapter

class MainPagerAdapter(
    private val fragments: List<BaseFragment>,
    private val onMainPagerItemClickListener: OnMainPagerItemClickListener
) : BaseAdapter<ItemMainPagerBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_main_pager

    override fun onCreateView(inflater: LayoutInflater, layoutId: Int, parent: ViewGroup, attachToParent: Boolean): ItemMainPagerBinding =
        DataBindingUtil.inflate<ItemMainPagerBinding>(inflater, layoutId, parent, attachToParent)
            .apply { listener = onMainPagerItemClickListener }

    override fun onBind(viewDataBinding: ItemMainPagerBinding, position: Int) {
        viewDataBinding.fragment = fragments[position]
    }

    override fun getItemCount(): Int = fragments.size

    interface OnMainPagerItemClickListener {
        fun onItemClick(fragment: BaseFragment)
    }
}