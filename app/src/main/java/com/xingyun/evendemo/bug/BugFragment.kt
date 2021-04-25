package com.xingyun.evendemo.bug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.bug.softkeyboard.InputModeFragment
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentListBinding

class BugFragment : BaseFragment(),
        ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentListBinding

    override val toolbarTitle: String = "Bug收集处"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentListBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = listOf(
                InputModeFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(fragments, this@BugFragment)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}