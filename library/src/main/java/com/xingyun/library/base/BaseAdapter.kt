package com.xingyun.library.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<D, VB : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<VB>>() {
    protected val data: MutableList<D> = mutableListOf();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> =
            BaseViewHolder(DataBindingUtil.inflate<VB>(LayoutInflater.from(parent.context), getLayoutRes(), parent, false)
                    .also { onDataBindingCreated(it) })

    abstract fun getLayoutRes(): Int

    open fun onDataBindingCreated(viewDataBinding: VB) = Unit

    override fun onBindViewHolder(viewHolder: BaseViewHolder<VB>, position: Int) {
        onBind(viewHolder.getViewDataBinding(), position)
    }

    override fun getItemCount(): Int = data.size

    abstract fun onBind(viewDataBinding: VB, position: Int)

    fun updateData(list: List<D>) {
        data.clear()
        data.addAll(list)
    }

}