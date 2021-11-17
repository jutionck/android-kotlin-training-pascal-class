package com.example.pascalandroid.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.fragment_welcome.view.*

class WelcomeFragment : Fragment() {

    private lateinit var welcomeTwoFragment: WelcomeTwoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        welcomeTwoFragment = WelcomeTwoFragment()
        view.btn_next.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, welcomeTwoFragment)
                ?.commit()
        }
        return view

    }
}