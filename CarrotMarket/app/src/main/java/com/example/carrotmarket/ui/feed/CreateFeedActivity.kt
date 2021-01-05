package com.example.carrotmarket.ui.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.carrotmarket.R
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_create_feed.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreateFeedActivity : AppCompatActivity() {
    private val viewModel: CreateFeedViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_feed)
        button.setOnClickListener {
            viewModel.postFeed(texttitle.text.toString(), textcontents.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({
                    val artid = it.article_id
                    val nextIntent = Intent(this, DetailFeedActivity::class.java)
                    nextIntent.putExtra("artid", artid)
                    startActivity(nextIntent)
                    finish()
                }, {
                    runOnUiThread { Toast.makeText(this, it.message, Toast.LENGTH_LONG).show() }
                })
        }
    }
}