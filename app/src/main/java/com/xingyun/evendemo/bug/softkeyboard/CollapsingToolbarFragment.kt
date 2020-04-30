package com.xingyun.evendemo.bug.softkeyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentCollapsingToolbarBinding
import com.xingyun.evendemo.utils.SoftHideKeyBoardUtil

class CollapsingToolbarFragment : BaseFragment() {
    private lateinit var binding: FragmentCollapsingToolbarBinding

    override val hasToolbar: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentCollapsingToolbarBinding>(inflater, R.layout.fragment_collapsing_toolbar, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            SoftHideKeyBoardUtil(it)
        }

        binding.btnTest.setOnClickListener {
            binding.scrollView.requestChildFocus(binding.llContainer, binding.et10)
        }
    }

}