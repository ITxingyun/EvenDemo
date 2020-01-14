package com.xingyun.evendemo.bug.softkeyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentInputModeBinding

class InputModeFragment : BaseFragment() {
    private lateinit var binding: FragmentInputModeBinding

    override fun getFragmentTag(): String = "InputModeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentInputModeBinding>(inflater, R.layout.fragment_input_mode, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCollapsing.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(CollapsingToolbarFragment())
        }

        binding.tvNotCollapsing.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(WithoutCollapsingToolbarFragment())
        }
    }
}