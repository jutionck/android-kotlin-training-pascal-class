package com.example.pascalandroid.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}