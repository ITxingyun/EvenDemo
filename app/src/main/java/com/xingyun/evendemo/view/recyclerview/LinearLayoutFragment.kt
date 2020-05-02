package com.xingyun.evendemo.view.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.app.SharedElementCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentRecyclerViewBinding
import com.xingyun.evendemo.view.recyclerview.adapter.CacheTestAdapter
import com.xingyun.evendemo.view.shareelement.ShareElementActivity

class LinearLayoutFragment : BaseFragment(), CacheTestAdapter.OnClickListener {
    private lateinit var binding: FragmentRecyclerViewBinding

    override val toolbarTitle: String = "LinearLayoutManager case"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentRecyclerViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CacheTestAdapter(this@LinearLayoutFragment)
            addItemDecoration(CacheTestAdapter.DivideDecorator(resources))
        }
    }


    override fun onClicked(text: String, view: ImageView) {
        activity?.run {
            val intent = Intent(this, ShareElementActivity::class.java)
            intent.putExtra("share", text)
            val options  = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, text)
            startActivityForResult(intent,1,  options.toBundle())
        }

    }
}