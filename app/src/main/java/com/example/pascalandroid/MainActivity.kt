package com.example.pascalandroid

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var txtInputName: TextInputEditText
    private lateinit var tvHelloName: TextView
    private lateinit var btnGreeting: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGreeting = findViewById(R.id.btn_greeting)
        btnGreeting.setOnClickListener { getNameFromInput() }

        txtInputName = findViewById(R.id.txt_input_name)
        tvHelloName = findViewById(R.id.tv_hello_name)
    }

    @SuppressLint("SetTextI18n")
    private fun getNameFromInput() {
        val getName = txtInputName.text
        Log.i("test", "Print getName $getName")

        val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study")
        val index = (0..3).random()
        val currentMessageGreeting = messageGreeting[index]

        if (getName.toString() == "") {
            tvHelloName.text = "Make sure to enter your name"
        } else {
            // update textView
            tvHelloName.text = "Hello $getName! $currentMessageGreeting"
        }
        // clear input text with setText
        txtInputName.setText("")

        hideKeyboard()
    }

    private fun hideKeyboard() {
        val inputMethodService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodService.hideSoftInputFromWindow(txtInputName.windowToken, 0)
    }
}