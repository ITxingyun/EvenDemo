package com.xingyun.library.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<DB : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<DB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DB> =
            BaseViewHolder(DataBindingUtil.inflate<DB>(LayoutInflater.from(parent.context), getLayoutRes(), parent, false)
                    .also { onDataBindingCreated(it) })

    abstract fun getLayoutRes(): Int

    open fun onDataBindingCreated(viewDataBinding: DB) = Unit

    override fun onBindViewHolder(viewHolder: BaseViewHolder<DB>, position: Int) {
        onBind(viewHolder.getViewDataBinding(), position)
    }

    abstract fun onBind(viewDataBinding: DB, position: Int)
}