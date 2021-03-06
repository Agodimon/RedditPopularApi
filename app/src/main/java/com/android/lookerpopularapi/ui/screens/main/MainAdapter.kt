package com.android.lookerpopularapi.ui.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.lookerpopularapi.data.models.childrenModels.Children
import com.android.lookerpopularapi.data.models.childrenModels.ChildrenData
import com.android.redditpopularapi.databinding.ItemPostBinding

class MainAdapter : PagingDataAdapter<Children, MainAdapter.PostViewHolder>(DiffUtilChildrenData) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.childrenData?.let { holder.bind(it) }
    }


    object DiffUtilChildrenData : DiffUtil.ItemCallback<Children>() {
        override fun areItemsTheSame(oldItem: Children, newItem: Children) =
            oldItem.childrenData == newItem.childrenData

        override fun areContentsTheSame(oldItem: Children, newItem: Children) =
            oldItem == newItem
    }

    inner class PostViewHolder(
        private val viewBinding: ItemPostBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(post: ChildrenData) {
            viewBinding.contentPost.text = post.title
            viewBinding.countOfMessages.text = post.numComments.toString()
            viewBinding.countLikes.text = post.totalAwardsReceived.toString()
        }

    }
}