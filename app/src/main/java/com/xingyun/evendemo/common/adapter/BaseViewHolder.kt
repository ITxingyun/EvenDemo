package com.xingyun.evendemo.common.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<DB : ViewDataBinding>(private val viewDataBinding: DB) : RecyclerView.ViewHolder(viewDataBinding.root) {
    fun getViewDataBinding(): DB = viewDataBinding
}