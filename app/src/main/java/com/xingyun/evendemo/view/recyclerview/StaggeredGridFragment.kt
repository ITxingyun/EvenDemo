package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding

class StaggeredGridFragment : BaseFragment() {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "StaggeredGridLayoutManager case"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {

        }
    }

}