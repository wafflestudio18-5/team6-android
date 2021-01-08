package com.example.carrotmarket.ui.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SellHistoryAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return SellHistoryFragment()
    }

}