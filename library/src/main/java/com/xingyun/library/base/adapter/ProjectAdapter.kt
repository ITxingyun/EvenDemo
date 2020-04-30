package com.xingyun.library.base.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.evendemo.databinding.ItemProjectBinding

class ProjectAdapter(
        private val fragments: List<BaseFragment>,
        private val onViewItemClickListener: OnViewItemClickListener
) : BaseAdapter<ItemProjectBinding>() {

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

    class ProjectItemDecoration : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

            outRect.set(0, 0, 0, 0)
        }
    }
}