package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pascalandroid.databinding.ActivityMainBinding
import com.example.pascalandroid.screen.CounterFragment
import com.example.pascalandroid.screen.CounterShowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentCounter: CounterFragment
    private lateinit var fragmentCounterShow: CounterShowFragment
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentCounter = CounterFragment()
        fragmentCounterShow = CounterShowFragment()
        with(binding) {
            supportFragmentManager.beginTransaction().add(counterFragment.id, fragmentCounter).commit()
            supportFragmentManager.beginTransaction().add(counterShowFragment.id, fragmentCounterShow).commit()
        }
    }

    fun notifyIncrease() {
        counter++
        Log.i("test", "NotifyIncrease $counter")
        fragmentCounterShow.notifyShowCounter(counter)
    }

    fun notifyDecrease() {
        counter--
        Log.i("test", "NotifyDecrease $counter")
        fragmentCounterShow.notifyShowCounter(counter)
    }
}