package com.example.pascalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var txtInputName: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGreeting: MaterialButton = findViewById(R.id.btn_greeting)
        btnGreeting.setOnClickListener { sendData() }

        txtInputName = findViewById(R.id.txt_input_name)
    }

    private fun sendData() {
        val intent =  Intent(this@MainActivity, SecondActivity::class.java)
        val sendName = txtInputName.text
        txtInputName.text = sendName
        intent.putExtra(SecondActivity.GET_NAME, txtInputName.text.toString())
        startActivity(intent)
    }
}