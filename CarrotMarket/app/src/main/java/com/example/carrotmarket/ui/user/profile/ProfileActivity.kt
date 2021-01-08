package com.example.carrotmarket.ui.user.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.ui.user.MyFeedActivity
import com.example.carrotmarket.ui.user.SellHistoryActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.also{
            it.badge.layout.setOnClickListener{openActivity(BadgeActivity::class.java)}
            it.product.layout.setOnClickListener{openActivity(ProfileSellHistoryActivity::class.java)}
            it.town.layout.setOnClickListener{openActivity(MyFeedActivity::class.java)}
            it.manner.layout.setOnClickListener{openActivity(MannerActivity::class.java)}
            it.review.layout.setOnClickListener{openActivity(ReviewActivity::class.java)}
        }
        binding.apply{
            lifecycleOwner = this@ProfileActivity
            viewModel = this@ProfileActivity.viewModel
        }
    }

    private fun openActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}