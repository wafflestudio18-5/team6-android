package com.example.carrotmarket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivitySignUpBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpActivity: AppCompatActivity() {
    private val viewModel: SignUpViewModel by viewModel()
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.signUpButton.setOnClickListener {
            viewModel.signUp()
        }
        viewModel.success.observe(this,
            Observer{
                if(it){
                    val nextIntent = Intent(this, MainActivity::class.java)
                    startActivity(nextIntent)
                    finish()
                }
            })
        binding.apply{
            lifecycleOwner = this@SignUpActivity
            binding.viewModel = this@SignUpActivity.viewModel
        }
    }
}