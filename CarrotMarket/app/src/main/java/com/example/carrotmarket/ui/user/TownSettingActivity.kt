package com.example.carrotmarket.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.databinding.ActivitySellHistoryBinding
import com.example.carrotmarket.databinding.ActivityTownSettingBinding
import com.example.carrotmarket.databinding.ActivityWatchlistBinding

class TownSettingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTownSettingBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_town_setting)
    }

}