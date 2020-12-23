package com.example.carrotmarket.feed

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.databinding.ItemFeedBinding

class FeedListAdapter : RecyclerView.Adapter<FeedViewHolder>(){
    private val items = mutableListOf<Feed>()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding =
            ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    fun setItems(feeds: List<Feed>){
        items.clear()
        items.addAll(feeds)
        notifyDataSetChanged()
    }
}

class FeedViewHolder(private val binding: ItemFeedBinding): RecyclerView.ViewHolder(binding.root){
    fun bindItems(feed: Feed){
        binding.item = feed
    }
}