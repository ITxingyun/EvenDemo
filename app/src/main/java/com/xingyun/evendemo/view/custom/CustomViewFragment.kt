package com.xingyun.evendemo.view.custom

import android.graphics.Outline
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentCustomViewBinding

class CustomViewFragment : BaseFragment() {
    private lateinit var binding: FragmentCustomViewBinding

    override val toolbarTitle: String = "自定义控件"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentCustomViewBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filter.update(
            listOf(
                "aaaaaa",
                "bbbbbbbbbb",
                "cccccc",
                "ddddd",
                "eeeeee",
                "fffff",
                "aaaaaaa",
                "bbbbbbbbabb",
                "ccccccs",
                "dddddxd",
                "esaeeeee",
                "fffaaff",
                "hhhhhhhhhhhhhh",
                "iiiiiiiiiiiiiiiiiiii",
                "aaaaaiiiiiiiiiiiiiiiiiiii",
                "aaassssiiiiiiiiiiiiiiiiiiii"
            )
        )

        binding.cbTest.setOnCheckedChangeListener({ buttonView, isChecked ->
            println("$isChecked")
        })

        binding.iv1.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRect(0, 0, (view?.width ?: 0), (view?.height ?: 0))
            }

        }

        binding.tagList.addTag(listOf("标签xx01", "标签sss02", "标签103", "标签4", "标签103", "标签4", "标签103"))
    }

}