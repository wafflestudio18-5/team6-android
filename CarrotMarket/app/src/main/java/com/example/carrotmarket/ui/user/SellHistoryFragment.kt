package com.example.carrotmarket.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.FragmentSellHistoryBinding
import com.example.carrotmarket.databinding.FragmentUserBinding
import com.google.android.material.tabs.TabLayoutMediator

class SellHistoryFragment: Fragment(){
    private lateinit var binding: FragmentSellHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sell_history, container, false)
        binding.recyclerView.adapter = ProductRecyclerAdapter()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        return binding.root
    }
}