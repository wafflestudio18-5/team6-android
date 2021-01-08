package com.example.carrotmarket.ui.user.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityBuyHistoryBinding
import com.example.carrotmarket.databinding.ActivityMannerBinding
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.databinding.ActivitySellHistoryBinding

class MannerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMannerBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manner)
    }
}