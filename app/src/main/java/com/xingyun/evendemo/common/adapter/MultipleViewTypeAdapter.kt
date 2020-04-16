package com.xingyun.evendemo.common.adapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class MultiViewTypeAdapter<D>(private var items: List<D>) : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding>>() {
    private val itemViews = SparseArray<ViewType<D, in ViewDataBinding>>()

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): BaseViewHolder<in ViewDataBinding> =
            itemViews.get(ViewType).onCreateViewHolder(parent)

    override fun getItemViewType(position: Int): Int {
        for (index in 0..itemViews.size()) {
            itemViews[index].run {
                if (isMatchViewType(items[position])) return getLayoutRes()
            }
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        itemViews[getItemViewType(position)].onBindView(holder.getViewDataBinding(), items[position])
    }

    fun addItemViewType(ViewType: ViewType<D, ViewDataBinding>) {
        itemViews.put(ViewType.getLayoutRes(), ViewType)
    }

    fun updateData(list: List<D>) {
        items = list
        notifyDataSetChanged()
    }

}

abstract class ViewType<D, DB: ViewDataBinding> {
    abstract fun isMatchViewType(data: Any?): Boolean

    abstract fun getLayoutRes(): Int

    open fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DB> =
            BaseViewHolder(DataBindingUtil.inflate<DB>(LayoutInflater.from(parent.context), getLayoutRes(), parent, false)
                    .also { onDataBindingCreated(it) })

    open fun onDataBindingCreated(viewDataBinding: DB) = Unit

    abstract fun onBindView(viewDataBinding: DB, data: D)

}
