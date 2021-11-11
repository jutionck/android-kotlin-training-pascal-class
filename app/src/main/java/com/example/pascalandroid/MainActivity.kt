package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pascalandroid.contoller.CounterHandler
import com.example.pascalandroid.fragment.CounterFragment
import com.example.pascalandroid.fragment.CounterShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, CounterHandler {

    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: CounterShowFragment
    private var counter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterFragment = CounterFragment()
        counterShowFragment = CounterShowFragment()
        btn_counter_fragment.setOnClickListener(this)
        btn_counter_show_fragment.setOnClickListener(this)

        // FragmentManager with transaction add()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, counterFragment).commit()
    }

    override fun notifyShowCounter(counter: Int) {
        counterShowFragment.notifyShowCounter(counter)
    }

    override fun notifyIncrease() {
        counter++
    }

    override fun notifyDecrease() {
        counter--
    }

    override fun onClick(v: View?) {
        when(v) {
            btn_counter_fragment -> switchFragment(counterFragment)
            btn_counter_show_fragment -> {
                counterShowFragment.counter = this.counter
                switchFragment(counterShowFragment)
            }
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}