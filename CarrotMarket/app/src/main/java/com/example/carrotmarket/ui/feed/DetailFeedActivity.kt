package com.example.carrotmarket.ui.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.R
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFeedActivity : AppCompatActivity() {
    private val viewModel : DetailFeedViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_feed)
    }
}