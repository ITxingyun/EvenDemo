package com.xingyun.evendemo.other

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentPermissionBinding

class PermissionFragment: BaseFragment() {
    private lateinit var binding: FragmentPermissionBinding

    override val toolbarTitle: String = "Permission"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentPermissionBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCamera.setOnClickListener {
            getCameraPermission()
        }

        binding.btnAlertWindow.setOnClickListener {
            getAlertWindowPermission()
        }

    }


    //系统的权限弹出框无法自定义样式
    private fun getCameraPermission() {
        activity?.let {
            if (ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //权限没有授权, 给用户解释
                if (ActivityCompat.shouldShowRequestPermissionRationale(it, Manifest.permission.CAMERA)) {

                } else {
                    //不解释，直接请求权限
                    ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.CAMERA), MY_PERMISSIONS_REQUEST_SYSTEM_CAMERA)

                }
            } else {
                //权限已经授权
            }
        }

    }

    private fun getAlertWindowPermission() {
        activity?.let {
            if (ContextCompat.checkSelfPermission(it, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.SYSTEM_ALERT_WINDOW), MY_PERMISSIONS_REQUEST_SYSTEM_ALERT_WINDOW)
            } else {
                //权限已经授权
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            MY_PERMISSIONS_REQUEST_SYSTEM_CAMERA -> {

            }

            MY_PERMISSIONS_REQUEST_SYSTEM_ALERT_WINDOW -> {

            }

            else -> {

            }
        }
    }

    companion object {
        const val MY_PERMISSIONS_REQUEST_SYSTEM_CAMERA = 1
        const val MY_PERMISSIONS_REQUEST_SYSTEM_ALERT_WINDOW = 2
    }

}