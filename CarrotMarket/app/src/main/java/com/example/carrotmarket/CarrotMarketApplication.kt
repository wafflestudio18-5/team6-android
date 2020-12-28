package com.example.carrotmarket

import android.app.Application
import com.example.carrotmarket.di.networkModule
import com.example.carrotmarket.di.repositoryModule
import com.example.carrotmarket.di.viewModelModule
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class CarrotMarketApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CarrotMarketApplication)
            modules(listOf(networkModule, viewModelModule, repositoryModule))
        }
        //카카오 SDK 초기화
        KakaoSdk.init(this, "a491f4206056cafb222c1b9c67a3b9d0")
    }


}