package com.example.islamicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamicapp.Fragments.HadethFragment
import com.example.islamicapp.Fragments.QuranFragment
import com.example.islamicapp.Fragments.RadioFragment
import com.example.islamicapp.Fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var btn_nav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btn_nav = findViewById(R.id.bottomNavigationView)
        showFragment(QuranFragment())
        btn_nav.setOnItemSelectedListener {
            if (it.itemId == R.id.icQuran) {
                showFragment(QuranFragment())

            } else if (it.itemId == R.id.icHaeth) {
                showFragment(HadethFragment())

            } else if (it.itemId == R.id.icsebha) {
                showFragment(SebhaFragment())

            } else {
                showFragment(RadioFragment())

            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}