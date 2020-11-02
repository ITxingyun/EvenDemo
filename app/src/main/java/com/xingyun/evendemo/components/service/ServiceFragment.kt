package com.xingyun.evendemo.components.service

import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentServiceBinding

class ServiceFragment : BaseFragment() {
    private lateinit var binding: FragmentServiceBinding

    override val toolbarTitle: String = "Service"

    private var myBinder: MyService.MyBinder? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            myBinder = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            if (service is MyService.MyBinder) {
                myBinder = service
            }
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentServiceBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvStartService.setOnClickListener {
            startService()
        }

        binding.tvBindService.setOnClickListener {
            myBinder?.test()
        }
    }

    private fun bindService() {
        val intent = Intent(activity, MyService::class.java)
        context?.bindService(intent, serviceConnection, BIND_AUTO_CREATE)
    }

    private fun startService() {
        val intent = Intent(activity, MyService::class.java)
        context?.startService(intent)
    }
}