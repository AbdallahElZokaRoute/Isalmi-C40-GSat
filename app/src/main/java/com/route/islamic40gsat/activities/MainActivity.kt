package com.route.islamic40gsat.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic40gsat.R
import com.route.islamic40gsat.databinding.ActivityMainBinding
import com.route.islamic40gsat.fragments.HadethFragment
import com.route.islamic40gsat.fragments.QuranFragment
import com.route.islamic40gsat.fragments.RadioFragment
import com.route.islamic40gsat.fragments.TasbeehFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("TAG", "onCreate: This is an important log")
        initViews()
    }

    private fun initViews() {
        binding.islamiBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> pushFragment(QuranFragment())
                R.id.navigation_hadeth -> pushFragment(HadethFragment())
                R.id.navigation_sebha -> pushFragment(TasbeehFragment())
                R.id.navigation_radio -> pushFragment(RadioFragment())
                else -> pushFragment(QuranFragment())
            }
            return@setOnItemSelectedListener true
        }
        binding.islamiBottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.islami_fragment_container, fragment)
            .commit()

    }
    // Testing Access Tokens
    // Git & Github (Version Control Systems) (VCS)
    // background => RED
    //   1.0
    // background => Green
    //   1.1
    //
    //   9 -> project
    //   1- Login
    //   2- Register
    //   3- Home
    //   4- Profile
    //   ....
    //
    //  Git & Github
    //  1- Initialize Project with git
    //  2-
    // Repository -> Holds Code Changes and Versions
    // Commit ->  Save Code Changes as Version
    // Local Repository -> Repository on Laptop/PC
    // // Github or Gitlab or BitBucket
//  Remote Repository :- Repository on Server
    // 1- Untracked - UnVersioned
    // 2- Tracked - Versioned
    // 3- Ignored
    // add files to git and initial commit

    /**
     *
     *  Hadeth Details Activity
     *  Handle Light/Dark Mode
     *  View Binding
     *  Room Database
     */


}