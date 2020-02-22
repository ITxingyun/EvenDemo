package com.xingyun.evendemo.view.searchview

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.databinding.FragmentSearchViewBinding
import com.xingyun.evendemo.view.recyclerview.RecyclerViewFragment

class SearchViewFragment : BaseFragment() {
    private lateinit var binding: FragmentSearchViewBinding

    override val toolbarTitle: String = "SearchView"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentSearchViewBinding>(inflater, R.layout.fragment_search_view, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTest.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(RecyclerViewFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    /**
     * menu的相关参考 https://www.yuque.com/docs/share/2dc1372f-ba9f-4c64-8f4f-1ee5770cdf24?#
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_view, menu)
        (menu.findItem(R.id.menu_search).actionView as SearchView).apply {
            queryHint = getString(R.string.menu_search)

            //展开搜索框
            //onActionViewExpanded()

            //搜索图标是否显示在搜索框内
            //setIconifiedByDefault(false)

            //设置搜索框展开时是否显示提交按钮，可不显示
            //isSubmitButtonEnabled = true

            //搜索框是否展开，false表示展开
            isIconified = false

            //设置searchView填充满toolbar
            //maxWidth = Integer.MAX_VALUE

            //让键盘的回车键设置成搜索
            imeOptions = EditorInfo.IME_ACTION_SEARCH


            //搜索监听
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    //do something
                    return false
                }

                override fun onQueryTextChange(query: String): Boolean {
                    //do something
                    return false
                }
            })


        }
    }




}