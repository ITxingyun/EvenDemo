package com.xingyun.evendemo.livedata

import android.databinding.ViewDataBinding
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<T : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val viewModelBinding = onCreateView(LayoutInflater.from(parent.context), getLayoutRes(), parent, false)
        return BaseViewHolder(viewModelBinding)
    }

    abstract fun getLayoutRes(): Int

    abstract fun onCreateView(
        @NonNull inflater: LayoutInflater, layoutId: Int, @Nullable parent: ViewGroup,
        attachToParent: Boolean
    ): T


    override fun onBindViewHolder(viewHolder: BaseViewHolder<T>, position: Int) {
        onBind(viewHolder.getViewModel(), position)
    }

    abstract fun onBind(viewDataBinding: T, position: Int)

}


class BaseViewHolder<T : ViewDataBinding>(private val t: T) : RecyclerView.ViewHolder(t.root) {
    fun getViewModel(): T = t
}