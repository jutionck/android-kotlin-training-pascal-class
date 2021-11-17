package com.example.pascalandroid.screens

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var registerFragment: RegisterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
        homeFragment = HomeFragment()
        registerFragment = RegisterFragment()
        view.btn_login.setOnClickListener {
            onLoginClicked()
        }

        view.btn_register.setOnClickListener {
           switchFragment(registerFragment)
        }

        return view
    }

    private fun switchFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragment)
            ?.commit()
    }

    private fun onLoginClicked() {
        val username = te_username.text.toString()
        val password = te_password.text.toString()
        if(username != "admin" && password != "admin") {
            showErrorDialog()
        } else {
            switchFragment(homeFragment)
        }
    }

    private fun showErrorDialog() {
        AlertDialog.Builder(activity)
            .setTitle("Login Failed")
            .setMessage("Username or password is not correct. Please try again.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

}