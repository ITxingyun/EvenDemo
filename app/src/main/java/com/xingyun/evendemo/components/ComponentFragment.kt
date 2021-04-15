package com.xingyun.evendemo.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.components.broadcast.BroadcastReceiverActivity
import com.xingyun.evendemo.components.service.ServiceActivity
import com.xingyun.evendemo.databinding.FragmentComponentBinding
import com.xingyun.library.utils.start

class ComponentFragment : BaseFragment() {
    private lateinit var binding: FragmentComponentBinding

    override val toolbarTitle: String = "四大组件"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentComponentBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvService.setOnClickListener {
            activity?.start<ServiceActivity>()
        }

        binding.tvContentProvider.setOnClickListener {

        }

        binding.tvBroadcastReceiver.setOnClickListener {
            activity?.start<BroadcastReceiverActivity>()
        }
    }


}