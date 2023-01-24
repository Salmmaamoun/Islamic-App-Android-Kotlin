package com.example.islamicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable{
            override fun run() {
                val intent=Intent(this@splashActivity,HomeActivity::class.java)
                startActivity(intent)
            }

        },3000)

    }
}

