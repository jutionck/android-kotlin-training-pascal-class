package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pascalandroid.contoller.CounterHandler
import com.example.pascalandroid.contoller.MessageController
import com.example.pascalandroid.fragment.CounterFragment
import com.example.pascalandroid.fragment.CounterShowFragment
import com.example.pascalandroid.fragment.MessageFragment
import com.example.pascalandroid.fragment.ShowMessageFragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MessageController {

    companion object {
        const val MESSAGE = "MESSAGE"
    }

    private lateinit var messageFragment: MessageFragment
    private lateinit var messageShowFragment: ShowMessageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageFragment = MessageFragment()
        messageShowFragment = ShowMessageFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, messageFragment).commit()
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun sendMessage(message: String) {
        val bundle = Bundle()
        bundle.putString(MESSAGE, message)
        messageShowFragment.arguments = bundle
        switchFragment(messageShowFragment)
    }
}