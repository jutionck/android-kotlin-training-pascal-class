package com.example.pascalandroid.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pascalandroid.databinding.ActivityCounterBinding
import com.example.pascalandroid.demo.screen.CounterFragment
import com.example.pascalandroid.demo.screen.CounterShowFragment

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
            supportFragmentManager.beginTransaction().add(counterFragment.id, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().add(counterShowFragment.id, fragmentCounterShow).commit()
        }
    }
}