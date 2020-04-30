package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding
import com.xingyun.evendemo.view.recyclerview.adapter.CacheTestAdapter

class LinearLayoutFragment : BaseFragment(){
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "LinearLayoutManager case"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CacheTestAdapter()
            addItemDecoration(CacheTestAdapter.DivideDecorator(resources))
        }
    }

}