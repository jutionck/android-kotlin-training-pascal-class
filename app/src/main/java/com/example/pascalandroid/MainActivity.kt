package com.example.pascalandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun btnGreetingPress(view: android.view.View) {
        Log.i("test", view.toString())
        val txtInputName: TextInputEditText = findViewById(R.id.txt_input_name)
        val tvHelloName: TextView = findViewById(R.id.tv_hello_name)

        val getNameFromInput = txtInputName.text
        tvHelloName.text = "Hello $getNameFromInput"

        txtInputName.setText("")
    }

}