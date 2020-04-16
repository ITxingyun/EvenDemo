package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding
import com.xingyun.evendemo.view.recyclerview.adapter.SimpleTextAdapter

class GridLayoutFragment : BaseFragment() {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "GridLayoutManager case"

    private val simpleList = listOf("Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows", "Go",
            "Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows",
            "Go", "Java", "kotlin", "C++", "C语言", "JS", "Html", "Android", "Ios", "PHP", "Windows", "Go")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2).apply {
                spanSizeLookup = object  : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                       return if (position % 3 == 0) 2 else 1
                    }
                }
            }
            adapter = SimpleTextAdapter(simpleList)
        }
    }

}