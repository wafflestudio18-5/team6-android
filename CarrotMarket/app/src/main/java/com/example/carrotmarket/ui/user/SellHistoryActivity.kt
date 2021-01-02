package com.example.carrotmarket.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.databinding.ActivitySellHistoryBinding
import com.google.android.material.tabs.TabLayoutMediator

class SellHistoryActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySellHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_history)

        binding.viewpager.adapter = SellHistoryAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewpager){tab, position->
            tab.text = when(position){
                0 -> "판매중"
                1 -> "거래완료"
                2 -> "숨김"
                else -> "error"
            }
        }.attach()
    }

}