package com.xingyun.evendemo.window

import android.graphics.PixelFormat
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentWindowBinding
import android.view.WindowManager
import android.os.Build

class WindowFragment : BaseFragment() {
    private lateinit var binding: FragmentWindowBinding

    override fun getFragmentTag(): String = "WindowFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentWindowBinding>(inflater, com.xingyun.evendemo.R.layout.fragment_window, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ViewModelProviders.of(this)
                .get(WindowViewModel::class.java)
                .also { binding.viewModel = it }
                .run {
                    window.observe(this@WindowFragment, Observer {
                        addWindow()
                    })
                }


    }

    private fun addWindow() {

        val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_PHONE
        }
        val flag = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE.or(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN).or(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        val button = Button(context).apply { text = "Button" }
        val layoutParams = WindowManager.LayoutParams(300, 300,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                type, PixelFormat.TRANSPARENT).apply { flags = flag}

        activity?.let {
            it.windowManager.addView(button, layoutParams)
        }
    }
}