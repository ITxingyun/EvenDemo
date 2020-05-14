package com.xingyun.evendemo.other.process

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentProcessBinding

class ProcessFragment: BaseFragment() {
    private lateinit var binding: FragmentProcessBinding

    override val toolbarTitle: String = "多进程"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentProcessBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStartActivity.setOnClickListener {
            startActivity(Intent(context, TestProcessActivity::class.java))
        }
    }


}