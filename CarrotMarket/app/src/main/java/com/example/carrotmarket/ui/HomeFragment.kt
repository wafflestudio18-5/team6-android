package com.example.carrotmarket.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.ViewModel
import com.example.carrotmarket.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment: Fragment(){
    private val viewModel: ViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }
}