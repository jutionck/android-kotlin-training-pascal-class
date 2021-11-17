package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pascalandroid.screens.WelcomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeFragment: WelcomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeFragment = WelcomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, welcomeFragment).commit()
    }
}