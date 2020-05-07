package com.xingyun.evendemo.view.custom.view

import android.database.Observable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.xingyun.evendemo.databinding.ItemFliterOptionBinding
import com.xingyun.evendemo.databinding.LayoutClearAllViewBinding
import com.xingyun.evendemo.databinding.LayoutExpandBinding

class FilterFlowAdapter(
        private val list: MutableList<String>) {

    var hasExpanded = false
    var expandViewPosition = 0

    private val viewById = HashMap<String, View>()
    private val observable = AdapterDataObservable()

    fun getClearAllView(parent: ViewGroup): View {
        return viewById[KEY_CLEAR_ALL_VIEW]
                ?: LayoutClearAllViewBinding.inflate(LayoutInflater.from(parent.context), parent, true)
                        .also { viewById[KEY_CLEAR_ALL_VIEW] = it.root }
                        .root
    }

    fun getExpandView(parent: ViewGroup): View {
        return viewById[KEY_EXPAND_VIEW]
                ?: LayoutExpandBinding.inflate(LayoutInflater.from(parent.context), parent, true)
                        .apply {
                            root.setOnClickListener {
                                hasExpanded = !hasExpanded
                                observable.notifyExpandView(hasExpanded)
                            }
                        }
                        .also { viewById[KEY_EXPAND_VIEW] = it.root }
                        .root
    }

    fun getView(position: Int, parent: ViewGroup): View {
        val itemId = getItemId(position)
        return viewById[itemId]
                ?: ItemFliterOptionBinding.inflate(LayoutInflater.from(parent.context), parent, true)
                        .apply {
                            text = list[position]
                            executePendingBindings()
                        }
                        .also { viewById[itemId] = it.root }
                        .root
    }

    fun getItemCount(): Int {
        return list.size
    }

    fun getExpandCount(): Int {
        return if (hasExpanded) list.size else expandViewPosition
    }

    private fun getItemId(position: Int): String = list[position]

    fun expand() {

    }

    fun removeFilterOption(optionName: String) {
        list.remove(optionName)
        observable.notifyItemRemove(viewById[optionName])
    }

    fun removeAllFilterOptions() {
        list.clear()
        viewById.clear()
        observable.notifyClearAllItem()
    }

    interface OnFilterOptionListener {

    }

    fun registryAdapterDataObserver(observer: AdapterDataObserver) {
        observable.registerObserver(observer)
    }

    fun unRegistryAdapterDataObserver(observer: AdapterDataObserver) {
        observable.unregisterObserver(observer)
    }

    class AdapterDataObservable : Observable<AdapterDataObserver>() {

        fun notifyItemRemove(view: View?) {
            view?.let { v ->
                mObservers.forEach {
                    it.removeItem(v)
                }
            }
        }

        fun notifyClearAllItem() {

        }

        fun notifyExpandView(isExpanded: Boolean) {
            mObservers.forEach {
                it.expandView(isExpanded)
            }
        }
    }

    interface AdapterDataObserver {
        fun removeItem(view: View)

        fun removeAll()

        fun expandView(isExpanded : Boolean)
    }

    companion object {
        private const val KEY_EXPAND_VIEW = "key1"
        private const val KEY_CLEAR_ALL_VIEW = "key2"
    }
}