package com.xingyun.evendemo.opensoruce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.adapter.ProjectAdapter
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentOpenSourceBinding
import com.xingyun.evendemo.opensoruce.http.okhttp.OkHttpFragment
import com.xingyun.evendemo.opensoruce.image.picasso.PicassoFragment

class OpenSourceFragment : BaseFragment(), ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentOpenSourceBinding

    override val toolbarTitle: String = "开源框架"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentOpenSourceBinding>(inflater, R.layout.fragment_open_source, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = listOf(
                OkHttpFragment(),
                PicassoFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(
                fragments,
                this@OpenSourceFragment
            )
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}