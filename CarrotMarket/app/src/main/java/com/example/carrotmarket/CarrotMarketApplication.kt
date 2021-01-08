package com.example.carrotmarket

import android.app.Application
import com.example.carrotmarket.di.networkModule
import com.example.carrotmarket.di.repositoryModule
import com.example.carrotmarket.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CarrotMarketApplication: Application(){
    companion object{
        lateinit var pref: SharedPreference
    }
    override fun onCreate() {
        pref = SharedPreference()
        super.onCreate()
        startKoin {
            androidContext(this@CarrotMarketApplication)
            modules(listOf(networkModule, viewModelModule, repositoryModule))
        }
    }
}