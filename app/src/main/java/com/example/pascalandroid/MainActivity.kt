package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIncrement: MaterialButton = findViewById(R.id.btn_increment)
        val btnDecrement: MaterialButton = findViewById(R.id.btn_decrement)
        btnIncrement.setOnClickListener { increment() }
        btnDecrement.setOnClickListener { decrement() }
        count = findViewById(R.id.tv_number_count)
    }

    private fun increment() {
        val currentNumber = count.text.toString().toInt()
        count.text = (currentNumber + 1).toString()
    }

    private fun decrement() {
        val currentNumber = count.text.toString().toInt()
        count.text = (currentNumber - 1).toString()
    }
}