package com.example.carrotmarket.ui.user.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityProfileSellHistoryBinding
import com.example.carrotmarket.ui.user.SellHistoryAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ProfileSellHistoryActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProfileSellHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_sell_history)

        binding.viewpager.adapter =
            SellHistoryAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewpager){tab, position->
            tab.text = when(position){
                0-> "전체"
                1 -> "판매중"
                2 -> "거래완료"
                else -> "error"
            }
        }.attach()
    }

}