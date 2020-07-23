package com.xingyun.evendemo.view.constraintlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentConstraintLayoutBinding

class ConstraintLayoutFragment: BaseFragment() {
    private lateinit var binding: FragmentConstraintLayoutBinding

    override val toolbarTitle: String = "ConstraintLayout"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentConstraintLayoutBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root
}