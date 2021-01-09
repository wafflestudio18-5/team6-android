package com.example.carrotmarket.ui.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.R
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.User
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
    val user: User = pref.user
    val token: String = pref.user.token
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_detail_feed
        )
        binding.lifecycleOwner = this@DetailFeedActivity
        binding.adapter = CommentListAdapter()
        binding.viewModel = viewModel
        wrcomtext.isVisible = false
        regcom.isVisible = false

        val feed_id = intent.getIntExtra("artid", 0)
        viewModel.detailFeed(feed_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                contentdf.text = it.contents
                titletext.text = it.title
                likenum.text = it.like_count.toString()
                if (it.article_writer_id != user.id) {
                    delbutton.isVisible = false
                    editbutton.isVisible = false
                }
                viewModel.getUsername(it.article_writer_id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        usernametext.text = it.username
                    }, {})
            }, { Log.e("detailfeedactivity", it.message.toString()) })
        likebutton.setOnClickListener {
            viewModel.like(feed_id)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
//                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                    val nextIntent = Intent(this, DetailFeedActivity::class.java)
                    nextIntent.putExtra("artid", feed_id)
                    startActivity(nextIntent)
                    finish()
                },{})
        }
        delbutton.setOnClickListener {
            viewModel.deleteFeed(feed_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({
                    Log.d("delete","delete")
                },{})
            finish()
        }
        regcom.setOnClickListener {
            viewModel.wrComment(feed_id, wrcomtext.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("tag","success write comments")
                    val nextIntent = Intent(this, DetailFeedActivity::class.java)
                    nextIntent.putExtra("artid", feed_id)
                    startActivity(nextIntent)
                    finish()
                },{Log.d("error","error")})
        }
        commentviewer.setOnClickListener {
            viewModel.getComments(feed_id)
            wrcomtext.isVisible = true
            regcom.isVisible = true
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