package com.xingyun.evendemo.framework.handler

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentHandlerBinding
import java.lang.ref.WeakReference

class HandlerFragment: BaseFragment() {
    private lateinit var binding: FragmentHandlerBinding
    override val toolbarTitle: String = "Handler"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentHandlerBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val handler = MyHandler(context!!)
        binding.btnSent.setOnClickListener {
            handler.sendMessage(Message().apply { obj = "1234" })
        }
    }


    class MyHandler(val context: Context): Handler() {
        private val weakReference = WeakReference<Context>(context)

        override fun handleMessage(msg: Message) {
            Toast.makeText(weakReference.get(), msg.obj.toString(), Toast.LENGTH_SHORT).show()
        }

    }

}