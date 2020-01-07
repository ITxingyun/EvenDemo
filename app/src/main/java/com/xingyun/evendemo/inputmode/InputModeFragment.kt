package com.xingyun.evendemo.inputmode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentInputModeBinding
import com.xingyun.evendemo.utils.SoftHideKeyBoardUtil

class InputModeFragment : BaseFragment() {
    override fun getFragmentTag(): String = "InputModeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentInputModeBinding>(inflater, com.xingyun.evendemo.R.layout.fragment_input_mode, container, false)
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            SoftHideKeyBoardUtil(it)
        }
    }
}