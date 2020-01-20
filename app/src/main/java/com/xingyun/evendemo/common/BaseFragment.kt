package com.xingyun.evendemo.common

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.home.MainActivityViewModel

abstract class BaseFragment : Fragment() {

    abstract fun getFragmentTag(): String

    fun showMessage(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }

    fun obtainViewModel() =
        activity?.let { ViewModelProviders.of(it).get(MainActivityViewModel::class.java) }
}