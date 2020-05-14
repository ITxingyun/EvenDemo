package com.xingyun.evendemo.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentListBinding
import com.xingyun.evendemo.other.process.ProcessFragment

class OtherFragment : BaseFragment(), ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentListBinding

    override val toolbarTitle: String = "其他"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentListBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = listOf(
                PermissionFragment(),
                ProcessFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(fragments, this@OtherFragment)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}