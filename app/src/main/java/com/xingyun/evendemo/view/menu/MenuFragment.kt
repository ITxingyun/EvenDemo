package com.xingyun.evendemo.view.menu

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.databinding.FragmentMenuBinding

class MenuFragment: BaseFragment() {
    private lateinit var binding: FragmentMenuBinding

    override val toolbarTitle: String = "Menu"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentMenuBinding>(inflater, R.layout.fragment_menu, container, false)
            .also { binding = it }
            .root

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_test, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when(item.itemId) {
                R.id.menu_news -> {

                    true
                }
                R.id.menu_search -> {

                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

}