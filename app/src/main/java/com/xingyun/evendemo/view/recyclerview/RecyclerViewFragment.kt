package com.xingyun.evendemo.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : BaseFragment() {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "RecyclerView"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentRecyclerViewBinding>(inflater, R.layout.fragment_recycler_view, container, false)
                    .also { binding = it }
                    .root

}