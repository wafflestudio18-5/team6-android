package com.example.carrotmarket.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.AuthType
import com.kakao.sdk.user.UserApiClient
import timber.log.Timber

class HomeFragment: Fragment(){
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        binding.buttonKakaoLogin.setOnClickListener{
            context?.let { it1 ->
                LoginClient.instance.loginWithKakaoAccount(it1, authType = AuthType.REAUTHENTICATE){ token, error->
                    if (error != null) {
                        Timber.d(error, "로그인 실패")
                    }
                    else if (token != null) {
                        Timber.d("로그인 성공 %s", token.accessToken)
                    }
                }
            }
        }

        binding.buttonKakaoLogout.setOnClickListener{
            UserApiClient.instance.logout{error->
                if (error != null) {
                    Timber.e(error, "로그아웃 실패. SDK에서 토큰 삭제됨.")
                }
                else {
                    Timber.d("로그아웃 성공. SDK에서 토큰 삭제됨.")
                }
            }
        }

        return binding.root
    }
}