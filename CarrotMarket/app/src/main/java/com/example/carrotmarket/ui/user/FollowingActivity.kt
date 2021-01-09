package com.example.carrotmarket.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityFollowingBinding
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.databinding.ActivitySellHistoryBinding
import com.example.carrotmarket.databinding.ActivityWatchlistBinding

class FollowingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFollowingBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_following)
    }

}