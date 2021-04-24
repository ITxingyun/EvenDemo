package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding
import com.xingyun.evendemo.view.recyclerview.adapter.CacheTestAdapter
import com.xingyun.evendemo.view.recyclerview.adapter.DragAdapter

/**
 * 可以拖拽的RecyclerView
 */
class DragListFragment : BaseFragment() {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "可以拖拽侧滑的RecyclerView"

    private val simpleList = mutableListOf("Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows", "Go",
        "Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows",
        "Go", "Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows", "Go")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dragAdapter = DragAdapter(simpleList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(CacheTestAdapter.DivideDecorator(resources))
        binding.recyclerView.adapter = dragAdapter
        ItemTouchHelper(MyItemTouchHelperCallback(dragAdapter)).attachToRecyclerView(binding.recyclerView)
    }

}