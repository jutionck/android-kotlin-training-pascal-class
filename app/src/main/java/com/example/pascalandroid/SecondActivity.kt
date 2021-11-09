package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {

    companion object {
        const val GET_NAME = "get_name"
    }

    private lateinit var tvHelloName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvHelloName = findViewById(R.id.tv_hello_name)

        val getName = intent.getStringExtra(GET_NAME)
        tvHelloName.text = getName

        val btnBack: MaterialButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { backButton() }
    }

    private fun backButton() {
        finish()
    }


}