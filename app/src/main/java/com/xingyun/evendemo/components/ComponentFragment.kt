package com.xingyun.evendemo.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentListBinding
import com.xingyun.evendemo.other.PermissionFragment

class ComponentFragment : BaseFragment(), ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentListBinding

    override val toolbarTitle: String = "四大组件"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentListBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val fragments = listOf(
//        )
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter = ProjectAdapter(fragments, this@ComponentFragment)
//        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}