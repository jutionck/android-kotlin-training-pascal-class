package com.example.pascalandroid

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_greeting.setOnClickListener(this)
    }

//    @SuppressLint("SetTextI18n")
//    private fun btnGreetingPress() {
//        val getNameFromInput = txtInputName.text
//        tvHelloName.text = "Hello $getNameFromInput"
//        txtInputName.setText("")
//        hideKeyboard()
//    }

    @SuppressLint("ServiceCast")
    private fun hideKeyboard() {
        val inputMethodService =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodService.hideSoftInputFromWindow(txt_input_name.windowToken, 0)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v) {
            btn_greeting -> {
                val getNameFromInput = txt_input_name.text
                val number = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study")
                val index = (0..3).random()
                val getRandomElement = number[index]
                if (getNameFromInput.toString() == "") {
                    tv_hello_name.text = "Make sure to enter your name"
                } else {
                    tv_hello_name.text = "Hello $getNameFromInput! $getRandomElement"
                }
                hideKeyboard()
                txt_input_name.setText("")
            }
        }
    }
}