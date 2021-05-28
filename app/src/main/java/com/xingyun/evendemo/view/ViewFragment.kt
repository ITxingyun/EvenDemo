package com.xingyun.evendemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentListBinding
import com.xingyun.evendemo.view.constraintlayout.ConstraintLayoutFragment
import com.xingyun.evendemo.view.custom.CustomViewFragment
import com.xingyun.evendemo.view.edittext.EditTextFragment
import com.xingyun.evendemo.view.menu.MenuFragment
import com.xingyun.evendemo.view.recyclerview.RecyclerViewFragment
import com.xingyun.evendemo.view.scroll.NestedScrollFragment
import com.xingyun.evendemo.view.searchview.SearchViewFragment
import com.xingyun.evendemo.view.textview.TextViewFragment
import com.xingyun.evendemo.view.viewpage.ViewPage2BugFragment
import com.xingyun.evendemo.view.viewpage.ViewPage2Fragment

class ViewFragment : BaseFragment(),
        ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentListBinding

    override val toolbarTitle: String = "Android控件Demo"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentListBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = listOf(
                CustomViewFragment(),
                NestedScrollFragment(),
                ViewPage2Fragment(),
                ViewPage2BugFragment(),
                MenuFragment(),
                SearchViewFragment(),
                RecyclerViewFragment(),
                ConstraintLayoutFragment(),
                TextViewFragment(),
                EditTextFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(fragments, this@ViewFragment)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}