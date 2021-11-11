package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pascalandroid.fragment.CounterFragment
import com.example.pascalandroid.fragment.CounterShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: CounterShowFragment
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterFragment = fragment_counter as CounterFragment
        counterShowFragment = fragment_counter_show as CounterShowFragment
    }

    fun notifyIncrease() {
        counter++
        Log.i("test", "NotifyIncrease $counter")
        counterShowFragment.notifyShowCounter(counter)
    }

    fun notifyDecrease() {
        counter--
        Log.i("test", "NotifyDecrease $counter")
        counterShowFragment.notifyShowCounter(counter)
    }
}