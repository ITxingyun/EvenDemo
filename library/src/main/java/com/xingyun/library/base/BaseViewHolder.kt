package com.xingyun.library.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<DB : ViewDataBinding>(private val viewDataBinding: DB) : RecyclerView.ViewHolder(viewDataBinding.root) {
    fun getViewDataBinding(): DB = viewDataBinding
}