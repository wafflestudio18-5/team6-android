package com.example.carrotmarket.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.FragmentChatBinding

class ChatFragment: Fragment(){
    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)

        return binding.root
    }
}