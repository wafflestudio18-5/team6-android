package com.example.carrotmarket.ui.user

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.carrotmarket.R

class PreferencesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, PreferencesFragment()).commit()
    }

}

class PreferencesFragment: PreferenceFragmentCompat(){

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        addOpenActivity("key_set_push_notification")
    }

    private fun addOpenActivity(key: String){
        findPreference<Preference>(key)?.setOnPreferenceClickListener {
            val intent = Intent(context,PushPreferencesActivity::class.java)
            startActivity(intent)
            return@setOnPreferenceClickListener true
        }
    }

}