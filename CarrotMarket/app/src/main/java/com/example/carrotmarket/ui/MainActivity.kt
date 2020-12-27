package com.example.carrotmarket.ui

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.ui.user.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MainActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ActivityMainBinding
    
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
            R.id.menu_home -> homeFragment
            R.id.menu_feed -> feedFragment
            R.id.menu_place -> placeFragment
            R.id.menu_chat -> chatFragment
            R.id.menu_user -> userFragment
            else -> error("no such item")
        }.let { fragment ->
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        }
        return true
    }



}