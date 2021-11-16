package com.example.pascalandroid.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btn_next.setOnClickListener {
            setIntent()
        }
    }

    private fun setIntent() {
        val intent = Intent(this, NextActivity::class.java)
        startActivity(intent)
        finish()
    }
}