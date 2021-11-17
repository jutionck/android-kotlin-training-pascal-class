package com.example.pascalandroid.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.fragment_welcome_two.view.*

class WelcomeTwoFragment : Fragment() {

    private lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_welcome_two, container, false)
        loginFragment = LoginFragment()
        view.btn_start.setOnClickListener {
            switchFragment(loginFragment)
        }
        return view
    }

    private fun switchFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragment)
            ?.commit()
    }

}