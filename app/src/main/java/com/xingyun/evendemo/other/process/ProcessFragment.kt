package com.xingyun.evendemo.other.process

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.IUser
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentProcessBinding
import com.xingyun.evendemo.other.process.client.ClientActivity
import com.xingyun.evendemo.other.process.server.RemoteService

class ProcessFragment: BaseFragment() {
    private lateinit var binding: FragmentProcessBinding

    override val toolbarTitle: String = "多进程"

    private var iUser : IUser? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentProcessBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStartActivity.setOnClickListener {
            startActivity(Intent(context, ClientActivity::class.java))
        }

        binding.btnAidl.setOnClickListener {
            if (iUser != null) {
                Log.e("ClientActivity", "userName = ${iUser?.userName}")
            } else {
                bindUserService()
            }

        }
    }

    private fun bindUserService() {
        val intent = Intent(context, RemoteService::class.java)
        intent.action = "user.ipc.server"
        activity?.bindService(intent, userServiceConnection, Context.BIND_AUTO_CREATE)
    }

    private val userServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            iUser = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iUser  = IUser.Stub.asInterface(service)
        }
    }

    override fun onStart() {
        super.onStart()
        bindUserService()
    }

    override fun onStop() {
        super.onStop()
        activity?.unbindService(userServiceConnection)
    }

}