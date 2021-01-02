package com.example.carrotmarket.ui.user.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.ui.user.MyFeedActivity
import com.example.carrotmarket.ui.user.SellHistoryActivity

class ProfileActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.badge.layout.setOnClickListener{openActivity(BadgeActivity::class.java)}
        binding.product.layout.setOnClickListener{openActivity(ProfileSellHistoryActivity::class.java)}
        binding.town.layout.setOnClickListener{openActivity(MyFeedActivity::class.java)}
        binding.manner.layout.setOnClickListener{openActivity(MannerActivity::class.java)}
        binding.review.layout.setOnClickListener{openActivity(ReviewActivity::class.java)}
    }

    private fun openActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}