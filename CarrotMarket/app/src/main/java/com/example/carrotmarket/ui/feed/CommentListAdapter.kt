package com.example.carrotmarket.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.api.Comment
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.Rcomment
import com.example.carrotmarket.databinding.ItemCommentBinding

class CommentListAdapter : RecyclerView.Adapter<CommentViewHolder>() {
    private val comments = mutableListOf<Rcomment>()

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindItem(comments[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    fun setItems(comment: List<Rcomment>) {
        comments.clear()
        comments.addAll(comment)
        notifyDataSetChanged()
    }

}

class CommentViewHolder(private val binding: ItemCommentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(comment: Rcomment) {
        binding.comment = comment
    }
}