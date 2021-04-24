package com.xingyun.evendemo.view.edittext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentEditTextBinding

class EditTextFragment : BaseFragment() {
    private lateinit var binding: FragmentEditTextBinding

    override val toolbarTitle: String = "EditView"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentEditTextBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etTest02.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) {
                binding.etTest02.setSelection(binding.etTest02.text?.length ?: 0)
            }
        }

    }


}