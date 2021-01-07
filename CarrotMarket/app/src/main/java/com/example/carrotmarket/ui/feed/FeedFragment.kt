package com.example.carrotmarket.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.FragmentFeedBinding
import com.example.carrotmarket.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.android.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {
    private val viewModel: FeedViewModel by viewModel()
    private lateinit var binding: FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        binding.lifecycleOwner = this@FeedFragment
        binding.adapter = FeedListAdapter()
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        floatingActionButton.setOnClickListener {
            val nextIntent = Intent(context, CreateFeedActivity::class.java)
            startActivity(nextIntent)
        }
    }
}