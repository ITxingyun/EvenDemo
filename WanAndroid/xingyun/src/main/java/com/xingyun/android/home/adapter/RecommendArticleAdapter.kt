package com.xingyun.android.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xingyun.android.databinding.ItemRecommendArticleBinding
import com.xingyun.storage.data.dp.RecommendArticle
import com.xingyun.storage.data.entity.Article

class RecommendArticleAdapter : PagingDataAdapter<RecommendArticle, RecyclerView.ViewHolder>(RecommendArticleCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecommendArticleViewHolder(
            ItemRecommendArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        (holder as RecommendArticleViewHolder).bind(article)
    }


    class RecommendArticleViewHolder(
        private val binding: ItemRecommendArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recommendArticle: RecommendArticle?) {
            binding.apply {
                article = recommendArticle
                executePendingBindings()
            }
        }
    }

}

private class RecommendArticleCallback : DiffUtil.ItemCallback<RecommendArticle>() {

    override fun areItemsTheSame(oldItem: RecommendArticle, newItem: RecommendArticle): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecommendArticle, newItem: RecommendArticle): Boolean {
        return oldItem.id == newItem.id
    }

}