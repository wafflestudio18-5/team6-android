package com.example.carrotmarket.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityKeywordNoticeBinding
import com.example.carrotmarket.databinding.ActivityProfileBinding
import com.example.carrotmarket.databinding.ActivitySellHistoryBinding
import com.example.carrotmarket.databinding.ActivityWatchlistBinding

class KeywordNoticeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityKeywordNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_keyword_notice)
    }

}