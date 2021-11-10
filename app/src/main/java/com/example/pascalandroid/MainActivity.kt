package com.example.pascalandroid

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import java.lang.NumberFormatException


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
                val number: Int = txt_input_name.text.toString().toInt()
                if (number == 0) {
                    Toast.makeText(this, "Can't input zero number", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                val motivateMessage = listOf<String>(
                    "Have nice day",
                    "Never give up",
                    "Keep working hard",
                    "Keep your study"
                )
                val index = (0..3).random()
                val getRandomElement = motivateMessage[index]
                tv_hello_name.text = "Hello $number! $getRandomElement"
                hideKeyboard()
                txt_input_name.setText("")

            }
        }
    }
}