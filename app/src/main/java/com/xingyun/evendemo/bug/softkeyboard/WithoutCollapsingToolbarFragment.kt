package com.xingyun.evendemo.bug.softkeyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentWithoutCollapsingToolbarBinding
import com.xingyun.evendemo.utils.SoftHideKeyBoardUtil

class WithoutCollapsingToolbarFragment : BaseFragment() {

    override fun getFragmentTag(): String = "WithoutCollapsingToolbarFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentWithoutCollapsingToolbarBinding>(inflater, R.layout.fragment_without_collapsing_toolbar, container, false)
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            SoftHideKeyBoardUtil(it)
        }
    }

}