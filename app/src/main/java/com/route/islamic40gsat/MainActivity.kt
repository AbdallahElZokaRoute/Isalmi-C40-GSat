package com.route.islamic40gsat

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.route.islamic40gsat.fragments.HadethFragment
import com.route.islamic40gsat.fragments.QuranFragment
import com.route.islamic40gsat.fragments.RadioFragment
import com.route.islamic40gsat.fragments.TasbeehFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.islami_bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> pushFragment(QuranFragment())
                R.id.navigation_hadeth -> pushFragment(HadethFragment())
                R.id.navigation_sebha -> pushFragment(TasbeehFragment())
                R.id.navigation_radio -> pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.navigation_quran
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

}