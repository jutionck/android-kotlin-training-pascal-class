package com.example.pascalandroid.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.R
import com.example.pascalandroid.communicator.CounterCommunicator
import com.example.pascalandroid.databinding.ActivityCounterBinding
import com.example.pascalandroid.demo.screen.CounterFragment
import com.example.pascalandroid.demo.screen.CounterShowFragment
import com.example.pascalandroid.demo.viewmodel.CounterVIewModel

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private lateinit var fragmentCounter: CounterFragment
    private lateinit var fragmentCounterShow: CounterShowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentCounter = CounterFragment()
        fragmentCounterShow = CounterShowFragment()
        binding.apply {
            supportFragmentManager.beginTransaction().add(binding.counterFragment.id, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().add(binding.counterShowFragment.id, fragmentCounterShow).commit()
        }
    }
}