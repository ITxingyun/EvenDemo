package com.xingyun.evendemo.framework.window

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.databinding.FragmentWindowBinding
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.xingyun.evendemo.common.ui.BaseFragment

class WindowFragment : BaseFragment() {
    private lateinit var binding: FragmentWindowBinding

    override val toolbarTitle: String = "Windows"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentWindowBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            if (ContextCompat.checkSelfPermission(it, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.SYSTEM_ALERT_WINDOW), 1)
            }
        }

        binding.tvNewWindow.setOnClickListener {
            permission()
        }

    }

    private fun addWindow() {
        val flag = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE.or(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN).or(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        val button = Button(context).apply { text = "Button" }
        val layoutParams = WindowManager.LayoutParams(300, 300,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                flag, PixelFormat.TRANSPARENT)

        activity?.let {
            it.windowManager.addView(button, layoutParams)
        }
    }

    private fun permission() {
        if (!Settings.canDrawOverlays(context)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivity(intent)
            return
        } else {
            //Android6.0以上
            addWindow()
        }
    }
}