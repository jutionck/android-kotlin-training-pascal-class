package com.example.pascalandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.MainActivity
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.fragment_show_message.view.*

class ShowMessageFragment : Fragment() {

    private var getMessage: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_show_message, container, false)
        getMessage = arguments?.getString(MainActivity.MESSAGE)
        view.tv_hello_name.text = getMessage
        return view
    }
}