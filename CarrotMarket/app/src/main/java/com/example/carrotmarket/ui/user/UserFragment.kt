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
        binding.also{
            it.userProfile.profileLayout.setOnClickListener{ openActivity(ProfileActivity::class.java) }

            it.userHistory.sellHistory.setOnClickListener{ openActivity(SellHistoryActivity::class.java) }
            it.userHistory.buyHistory.setOnClickListener{ openActivity(BuyHistoryActivity::class.java) }
            it.userHistory.watchlist.setOnClickListener{ openActivity(WatchlistActivity::class.java) }

            it.townSetting.layout.setOnClickListener{ openActivity(TownSettingActivity::class.java) }
            it.townVerify.layout.setOnClickListener{ openActivity(TownVerifyActivity::class.java) }
            it.keywordNotice.layout.setOnClickListener{ openActivity(KeywordNoticeActivity::class.java) }
            it.following.layout.setOnClickListener{ openActivity(FollowingActivity::class.java) }

            it.myFeed.layout.setOnClickListener{ openActivity(MyFeedActivity::class.java) }
            it.myFeedComment.layout.setOnClickListener{ openActivity(MyFeedActivity::class.java) }
            it.townSubject.layout.setOnClickListener{ openActivity(TownSubjectActivity::class.java) }

            it.CEOMenu.layout.setOnClickListener{ openActivity(CEOMenuActivity::class.java) }

            it.friendInvite.layout.setOnClickListener{ openActivity(FriendInviteActivity::class.java) }
            it.share.layout.setOnClickListener{ openActivity(ShareActivity::class.java) }
            it.announcements.layout.setOnClickListener{ openActivity(AnnouncementsActivity::class.java) }
            it.FAQ.layout.setOnClickListener{ openActivity(FAQActivity::class.java) }
            it.preferences.layout.setOnClickListener{ openActivity(PreferencesActivity::class.java) }
        }
        viewModel.getUserInfo()
        binding.apply{
            lifecycleOwner = this@UserFragment
            viewModel = this@UserFragment.viewModel
        }
    }

    private fun openActivity(activity: Class<*>){
        activity.let{
            val intent = Intent(context, activity)
            startActivity(intent)
        }
    }
}