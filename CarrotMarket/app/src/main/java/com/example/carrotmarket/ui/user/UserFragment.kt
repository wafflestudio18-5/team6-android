package com.example.carrotmarket.ui.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.FragmentUserBinding
import com.example.carrotmarket.ui.user.preference.PreferencesActivity
import com.example.carrotmarket.ui.user.profile.ProfileActivity
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment: Fragment(){
    private val viewModel: UserViewModel by viewModel()
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.userProfile.profileLayout.setOnClickListener{ openActivity(ProfileActivity::class.java) }

        binding.userHistory.sellHistory.setOnClickListener{ openActivity(SellHistoryActivity::class.java) }
        binding.userHistory.buyHistory.setOnClickListener{ openActivity(BuyHistoryActivity::class.java) }
        binding.userHistory.watchlist.setOnClickListener{ openActivity(WatchlistActivity::class.java) }

        binding.townSetting.layout.setOnClickListener{ openActivity(TownSettingActivity::class.java) }
        binding.townVerify.layout.setOnClickListener{ openActivity(TownVerifyActivity::class.java) }
        binding.keywordNotice.layout.setOnClickListener{ openActivity(KeywordNoticeActivity::class.java) }
        binding.following.layout.setOnClickListener{ openActivity(FollowingActivity::class.java) }

        binding.myFeed.layout.setOnClickListener{ openActivity(MyFeedActivity::class.java) }
        binding.myFeedComment.layout.setOnClickListener{ openActivity(MyFeedActivity::class.java) }
        binding.townSubject.layout.setOnClickListener{ openActivity(TownSubjectActivity::class.java) }

        binding.CEOMenu.layout.setOnClickListener{ openActivity(CEOMenuActivity::class.java) }

        binding.friendInvite.layout.setOnClickListener{ openActivity(FriendInviteActivity::class.java) }
        binding.share.layout.setOnClickListener{ openActivity(ShareActivity::class.java) }
        binding.announcements.layout.setOnClickListener{ openActivity(AnnouncementsActivity::class.java) }
        binding.FAQ.layout.setOnClickListener{ openActivity(FAQActivity::class.java) }
        binding.preferences.layout.setOnClickListener{ openActivity(PreferencesActivity::class.java) }

        binding.userName = viewModel.user.value?.userName
        binding.town = viewModel.user.value?.town
    }

    private fun openActivity(activity: Class<*>){
        activity.let{
            val intent = Intent(context, activity)
            startActivity(intent)
        }
    }
}