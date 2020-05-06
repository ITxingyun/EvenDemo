package com.xingyun.evendemo.view.custom.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.databinding.ItemFliterOptionBinding
import com.xingyun.evendemo.databinding.LayoutClearAllViewBinding
import com.xingyun.evendemo.databinding.LayoutExpandBinding

class FilterFlowAdapter(
        private val list: List<String>) {

    var hasExpanded = false
    var expandViewPosition = 0
    private val viewById = HashMap<String, View>()

    fun getClearAllView(parent: ViewGroup): View {
        return viewById[KEY_CLEAR_ALL_VIEW]
                ?: LayoutClearAllViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                        .also { viewById[KEY_CLEAR_ALL_VIEW] = it.root }
                        .root

    }

    fun getExpandView(parent: ViewGroup): View {
        return viewById[KEY_EXPAND_VIEW]
                ?: LayoutExpandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                        .also { viewById[KEY_EXPAND_VIEW] = it.root }
                        .root
    }

    fun getView(position: Int, parent: ViewGroup): View {
        val itemId = getItemId(position)
        return viewById[itemId]
                ?: ItemFliterOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                        .apply { text = list[position] }
                        .also { viewById[itemId] = it.root }
                        .root
    }

    fun getItemCount(): Int {
        return list.size
    }

    fun getItem(position: Int): String = list[position]

    fun getItemId(position: Int): String = list[position]

    fun expand() {

    }


    companion object {
        private const val KEY_EXPAND_VIEW = "key1"
        private const val KEY_CLEAR_ALL_VIEW = "key2"
    }


}