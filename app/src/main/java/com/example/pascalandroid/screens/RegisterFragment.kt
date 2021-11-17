package com.example.pascalandroid.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    private lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_register, container, false)
        loginFragment = LoginFragment()
        view.btn_register.setOnClickListener {
            Toast.makeText(activity, "Register successfully!", Toast.LENGTH_LONG).show()
            switchFragment(loginFragment)
        }

        view.btn_login.setOnClickListener {
            switchFragment(loginFragment)
        }
        return view
    }

    private fun switchFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragment)
            ?.commit()
    }

}