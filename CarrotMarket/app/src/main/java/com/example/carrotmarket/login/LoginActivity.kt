package com.example.carrotmarket.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.R
import com.example.carrotmarket.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
            finish()
        }
        registorButton.setOnClickListener {
            val nextIntent = Intent(this, RegistorActivity::class.java)
            startActivity(nextIntent)
            finish()
        }
    }
}