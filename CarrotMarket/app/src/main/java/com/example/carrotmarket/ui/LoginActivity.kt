package com.example.carrotmarket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity: AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginButton.setOnClickListener {
            viewModel.login()
        }
        viewModel.success.observe(this,
            Observer{
                if(it){
                    val nextIntent = Intent(this, MainActivity::class.java)
                    startActivity(nextIntent)
                    finish()
                }
            })
        binding.signUpButton.setOnClickListener {
            val nextIntent = Intent(this, SignUpActivity::class.java)
            startActivity(nextIntent)
            finish()
        }
        binding.apply{
            lifecycleOwner = this@LoginActivity
            binding.viewModel = this@LoginActivity.viewModel
        }
    }
}