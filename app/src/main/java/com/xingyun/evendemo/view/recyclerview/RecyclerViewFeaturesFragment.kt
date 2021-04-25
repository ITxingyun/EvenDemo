package com.xingyun.evendemo.view.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import com.xingyun.evendemo.view.recyclerview.animator.DefaultItemAnimator
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewFeaturesBinding
import com.xingyun.evendemo.view.recyclerview.adapter.DivideDecorator
import com.xingyun.evendemo.view.recyclerview.adapter.ListAdapter
import com.xingyun.evendemo.view.shareelement.ShareElementActivity

/**
 * recyclerView各种功能实验
 */
class RecyclerViewFeaturesFragment : BaseFragment(), ListAdapter.OnClickListener {
    private lateinit var binding: FragmentRecyclerViewFeaturesBinding
    private lateinit var adapter: ListAdapter

    override val toolbarTitle: String = "RecyclerView Features"

    private val list = listOf("宋江", "卢俊义", "燕青", "时迁", "鲁智深", "武松", "扈三娘", "石英", "花容", "李逵", "林冲",
            "史进", "杨雄", "杨志", "张清", "关胜", "鲍旭", "金大坚", "孙二娘", "戴宗", "刘唐", "陈达", "龚旺", "安道全",
            "凌振", "朱武", "阮小二", "张顺")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewFeaturesBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animator = DefaultItemAnimator()
        animator.removeDuration = 30
        animator.moveDuration = 220
        binding.recyclerView.apply {
            adapter = ListAdapter(this@RecyclerViewFeaturesFragment)
                    .apply { updateData(list) }
                    .also { this@RecyclerViewFeaturesFragment.adapter = it }
            addItemDecoration(DivideDecorator(resources))
            itemAnimator = animator
        }

        binding.tvAdd.setOnClickListener {
            val input = binding.etAdd.text.toString().trim()
            if (input.isNotEmpty()) {
                val index = Integer.valueOf(input)
                adapter.add(index)
            }
        }
    }


    override fun onClicked(text: String, view: ImageView) {
        //ShareElement demo
        activity?.run {
            val intent = Intent(this, ShareElementActivity::class.java)
            intent.putExtra("share", text)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, text)
            startActivityForResult(intent, 1, options.toBundle())
        }
    }

    override fun onRemoved(text: String) {
        adapter.remove(text)
    }
}