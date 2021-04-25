package com.xingyun.evendemo.view.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding
import com.xingyun.evendemo.view.recyclerview.adapter.CacheTestAdapter
import com.xingyun.evendemo.view.recyclerview.adapter.DivideDecorator
import com.xingyun.evendemo.view.shareelement.ShareElementActivity

class LinearLayoutFragment : BaseFragment(), CacheTestAdapter.OnClickListener {
    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var adapter: CacheTestAdapter

    override val toolbarTitle: String = "LinearLayoutManager case"

    private val list = listOf("宋江", "卢俊义", "燕青", "时迁", "鲁智深", "武松", "扈三娘", "石英", "花容", "李逵", "林冲",
            "史进", "杨雄", "杨志", "张清", "关胜", "鲍旭", "金大坚", "孙二娘", "戴宗", "刘唐", "陈达", "龚旺", "安道全",
            "凌振", "朱武", "阮小二", "张顺")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animator = DefaultItemAnimator()
        animator.removeDuration = 300
        animator.moveDuration = 2220
        binding.recyclerView.apply {
            adapter = CacheTestAdapter(this@LinearLayoutFragment)
                    .apply { updateData(list) }.also { this@LinearLayoutFragment.adapter = it }
            addItemDecoration(DivideDecorator(resources))
            itemAnimator = animator
        }
    }


    override fun onClicked(text: String, view: ImageView) {
        activity?.run {
            val intent = Intent(this, ShareElementActivity::class.java)
            intent.putExtra("share", text)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, text)
            startActivityForResult(intent, 1, options.toBundle())
        }
    }

    override fun onRemoved(position: Int) {
        adapter.remove(position)
    }
}