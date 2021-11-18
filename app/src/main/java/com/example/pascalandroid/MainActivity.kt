package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pascalandroid.communicator.MessageCommunicator
import com.example.pascalandroid.databinding.ActivityMainBinding
import com.example.pascalandroid.screen.GreetingFragment
import com.example.pascalandroid.screen.HomeFragment

class MainActivity : AppCompatActivity(), MessageCommunicator {

    companion object {
        const val MESSAGE = "MESSAGE"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentGreeting: GreetingFragment
    private lateinit var fragmentHome: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentGreeting = GreetingFragment()
        fragmentHome = HomeFragment()
        with(binding) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id, fragmentGreeting)
                .commit()
        }
    }

    override fun sendMessage(message: String) {
        val bundle = Bundle()
        bundle.putString(MESSAGE, message)
        fragmentHome.arguments = bundle
        switchFragment(fragmentHome)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }


}