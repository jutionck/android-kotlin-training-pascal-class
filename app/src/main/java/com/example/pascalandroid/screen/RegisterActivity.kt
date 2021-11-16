package com.example.pascalandroid.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pascalandroid.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            Toast.makeText(this, "Register successfully!", Toast.LENGTH_LONG).show()
            finish()
        }

        btn_login.setOnClickListener {
            finish()
        }
    }
}