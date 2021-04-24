package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : BaseFragment(), ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "RecyclerView Demo"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentRecyclerViewBinding>(inflater, R.layout.fragment_recycler_view, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            context?.let { layoutManager = LinearLayoutManager(context) }
            adapter = ProjectAdapter(listOf(
                    LinearLayoutFragment(),
                    GridLayoutFragment(),
                    StaggeredGridFragment(),
                    DragListFragment()
            ), this@RecyclerViewFragment)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}