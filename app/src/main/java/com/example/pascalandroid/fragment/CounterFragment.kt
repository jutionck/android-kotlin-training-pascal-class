package com.example.pascalandroid.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.MainActivity
import com.example.pascalandroid.R
import com.example.pascalandroid.contoller.CounterHandler
import kotlinx.android.synthetic.main.fragment_counter.*
import kotlinx.android.synthetic.main.fragment_counter.view.*

class CounterFragment : Fragment(), View.OnClickListener {

    private lateinit var counterHandler: CounterHandler
    private var counter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterHandler = activity as CounterHandler
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
                counter++
                counterHandler.notifyShowCounter(counter)
            }
            btn_decrease -> {
                Log.i("test", "Decrease Button pressed")
                counter--
                counterHandler.notifyShowCounter(counter)
            }
        }
    }
}