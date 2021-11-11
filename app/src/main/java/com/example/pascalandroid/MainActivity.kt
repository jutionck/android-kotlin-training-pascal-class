package com.example.pascalandroid

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_greeting.setOnClickListener(this)
        btn_implicit.setOnClickListener(this)
    }

    @SuppressLint("ServiceCast")
    private fun hideKeyboard() {
        val inputMethodService =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodService.hideSoftInputFromWindow(txt_input_name.windowToken, 0)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v) {
            btn_greeting -> setIntent()
            btn_implicit -> setIntent("implicit")
        }
    }

    private fun setIntent(typeOfIntent: String = "explicit") {
        when(typeOfIntent) {
            "explicit" -> {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                val message = sendMessage()
                intent.putExtra(SecondActivity.GET_NAME, message)
                startActivity(intent)
                txt_input_name.setText("")
            }
            "implicit" -> {
                val imp = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enigmacamp.com/"))
                startActivity(imp)
            }
        }

    }

    private fun sendMessage(): String {
        val getName = txt_input_name.text.toString()
        val motivateMessage = listOf<String>(
            "Have nice day",
            "Never give up",
            "Keep working hard",
            "Keep your study"
        )
        val index = (0..3).random()
        val getRandomElement = motivateMessage[index]
        return "$getName! \n$getRandomElement"
    }
}