package com.example.pascalandroid.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pascalandroid.databinding.ActivityGreetingBinding
import com.example.pascalandroid.demo.screen.QuoteShowFragment
import com.example.pascalandroid.demo.screen.QuotesFragment

class GreetingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGreetingBinding
    private lateinit var fragmentQuotes: QuotesFragment
    private lateinit var fragmentQuoteShow: QuoteShowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentQuotes = QuotesFragment()
        fragmentQuoteShow = QuoteShowFragment()
        binding.apply {
            supportFragmentManager.beginTransaction().add(fragmentContainerGreeting.id, fragmentQuotes).commit()
        }
    }
}