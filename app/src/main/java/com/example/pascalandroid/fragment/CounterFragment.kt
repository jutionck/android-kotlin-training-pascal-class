package com.example.pascalandroid.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.MainActivity
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.fragment_counter.*
import kotlinx.android.synthetic.main.fragment_counter.view.*

class CounterFragment : Fragment(), View.OnClickListener {

    // ketika melakukan komunikasi yang langsung memanggil activity (tidak di rekomendasikan)
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_counter, container, false)
        view.btn_increase.setOnClickListener(this)
        view.btn_decrease.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when(v) {
            btn_increase -> {
                Log.i("test", "Increase Button pressed")
                mainActivity.notifyIncrease()
            }
            btn_decrease -> {
                Log.i("test", "Decrease Button pressed")
                mainActivity.notifyDecrease()
            }
        }
    }
}