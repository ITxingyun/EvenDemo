package com.xingyun.evendemo.other.toast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentToastBinding

class ToastFragment : BaseFragment() {

    private lateinit var binding: FragmentToastBinding

    override val toolbarTitle: String = "Toast"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentToastBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvContinuedShow.setOnClickListener {
            showContinueToast()
        }
    }

    private fun showContinueToast() {
        context?.let {

        }
    }
}