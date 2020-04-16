package com.xingyun.evendemo.common.ui

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.R
import com.xingyun.evendemo.home.MainActivityViewModel

abstract class BaseFragment : Fragment() {
    open val toolbarTitle: String = ""
    @DrawableRes
    protected open val navigationIcon: Int = R.drawable.back
    protected open val hasToolbar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(hasToolbar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        obtainViewModel()?.run {
            updateTitleString(toolbarTitle)
            hideToolbar(hasToolbar)
            if (this@BaseFragment.navigationIcon != 0) {
                updateNavigationIcon(this@BaseFragment.navigationIcon)
            }
        }

    }

    fun obtainViewModel() =
        activity?.let { ViewModelProviders.of(it).get(MainActivityViewModel::class.java) }

    fun showMessage(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }
}