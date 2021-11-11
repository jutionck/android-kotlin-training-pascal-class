package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pascalandroid.contoller.CounterHandler
import com.example.pascalandroid.fragment.CounterFragment
import com.example.pascalandroid.fragment.CounterShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CounterHandler {

    private lateinit var counterShowFragment: CounterShowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterShowFragment = fragment_counter_show as CounterShowFragment
    }

    override fun notifyShowCounter(counter: Int) {
        counterShowFragment.notifyShowCounter(counter)
    }
}