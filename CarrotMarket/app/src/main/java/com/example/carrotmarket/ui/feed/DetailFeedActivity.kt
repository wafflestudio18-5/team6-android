package com.example.carrotmarket.ui.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityDetailFeedBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_feed.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_feed.*
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFeedActivity : AppCompatActivity() {
    private val viewModel: DetailFeedViewModel by viewModel()
    private lateinit var binding: ActivityDetailFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_detail_feed
        )
        binding.lifecycleOwner = this@DetailFeedActivity
        binding.adapter = CommentListAdapter()
        binding.viewModel = viewModel

        val feed_id = intent.getIntExtra("artid", 0)
        viewModel.detFeed(feed_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                contentdf.text = it.content
                titletext.text = it.title
                likenum.text = it.like_count.toString()
            }, {})
        likebutton.setOnClickListener {
            viewModel.like(feed_id)
        }
        delbutton.setOnClickListener {
            viewModel.delFeed(feed_id)
        }
        regcom.setOnClickListener {
            viewModel.wrcomment(feed_id, wrcomtext.text.toString())
        }
        commentviewer.setOnClickListener {
            viewModel.getcomments(feed_id)
        }
        editbutton.setOnClickListener {
            val intent = Intent(this, EditFeedActivity::class.java)
            intent.putExtra("title", titletext.text)
            intent.putExtra("content", contentdf.text)
            intent.putExtra("artid", feed_id)
            startActivity(intent)
            finish()
        }
    }
}