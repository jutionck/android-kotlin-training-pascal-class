package com.example.pascalandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.pascalandroid.R
import com.example.pascalandroid.communicator.MessageCommunicator
import com.example.pascalandroid.databinding.ActivityHomeBinding
import com.example.pascalandroid.screen.HomeFragment
import com.example.pascalandroid.screen.MessageFragment

class HomeActivity : AppCompatActivity() {

    companion object {
        const val MESSAGE = "MESSAGE"
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}