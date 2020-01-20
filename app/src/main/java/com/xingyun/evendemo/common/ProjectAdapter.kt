package com.xingyun.evendemo.common

import android.graphics.Rect
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ItemProjectBinding

class ProjectAdapter(
        private val fragments: List<BaseFragment>,
        private val onViewItemClickListener: OnViewItemClickListener
) : BaseAdapter<ItemProjectBinding>() {

    override fun getLayoutRes(): Int = R.layout.item_project

    override fun onCreateView(inflater: LayoutInflater, layoutId: Int, parent: ViewGroup, attachToParent: Boolean): ItemProjectBinding =
            DataBindingUtil.inflate<ItemProjectBinding>(inflater, layoutId, parent, attachToParent)
                    .apply { listener = onViewItemClickListener }

    override fun onBind(viewDataBinding: ItemProjectBinding, position: Int) {
        viewDataBinding.fragment = fragments[position]
    }

    override fun getItemCount(): Int = fragments.size

    interface OnViewItemClickListener {
        fun onItemClick(fragment: BaseFragment)
    }

    class HomePager : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

            outRect.set(0, 0, 0, 0)
        }
    }
}