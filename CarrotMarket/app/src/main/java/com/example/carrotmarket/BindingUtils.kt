package com.example.carrotmarket

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.feed.FeedListAdapter

@BindingAdapter("feeds")
fun bindItem(view: RecyclerView, feed: List<Feed>){
    val adapter = view.adapter as? FeedListAdapter
    if(feed != null){adapter?.setItems(feed)}
}