package com.example.carrotmarket.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.ViewModel
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModel()
    
    private val homeFragment = HomeFragment()
    private val feedFragment = FeedFragment()
    private val placeFragment = PlaceFragment()
    private val chatFragment = ChatFragment()
    private val userFragment = UserFragment()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val bottomNavigation = binding.bottomNavigation
        bottomNavigation.setOnNavigationItemSelectedListener(
            this
        )
        bottomNavigation.selectedItemId = R.id.menu_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit()
            }
            R.id.menu_feed -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, feedFragment).commit()
            }
            R.id.menu_place -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, placeFragment).commit()
            }
            R.id.menu_chat -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, chatFragment).commit()
            }
            R.id.menu_user -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, userFragment).commit()
            }
        }
        return true
    }
}