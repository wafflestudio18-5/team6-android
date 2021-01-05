package com.example.carrotmarket

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.api.Comment
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.Rcomment
import com.example.carrotmarket.ui.feed.CommentListAdapter
import com.example.carrotmarket.ui.feed.FeedListAdapter

@BindingAdapter("feeds")
fun bindItem(view: RecyclerView, feed: List<Feed>) {
    val adapter = view.adapter as? FeedListAdapter
    if (feed != null) {
        adapter?.setItems(feed)
    }
}

@BindingAdapter("coms")
fun bindComment(view: RecyclerView, comment: List<Rcomment>?) {
    val adapter = view.adapter as? CommentListAdapter
    if (comment != null) {
        adapter?.setItems(comment)
    }
}