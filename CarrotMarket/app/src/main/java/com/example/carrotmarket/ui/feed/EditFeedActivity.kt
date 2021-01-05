package com.example.carrotmarket.ui.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.carrotmarket.R
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_feed.*
import kotlinx.android.synthetic.main.activity_edit_feed.*
import org.koin.android.viewmodel.ext.android.viewModel

class EditFeedActivity : AppCompatActivity() {
    private val viewModel: EditFeedViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_feed)
        var content = intent.getStringExtra("content")
        var title = intent.getStringExtra("title")
        val feed_id = intent.getIntExtra("artid", 0)
        edcontenttext.setText(content)
        edtexttitle.setText(title)
        editbutton.setOnClickListener {
            var edcont = edcontenttext.text.toString()
            var edtit = edtexttitle.text.toString()
            viewModel.editFeed(feed_id, edtit, edcont)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({}, { Toast.makeText(this, it.message, Toast.LENGTH_LONG).show() })
            val intent = Intent(this, DetailFeedActivity::class.java)
            intent.putExtra("artid", feed_id)
            startActivity(intent)
            finish()
        }
    }
}