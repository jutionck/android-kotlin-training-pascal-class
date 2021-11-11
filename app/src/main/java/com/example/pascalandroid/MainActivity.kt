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
        btn_play.setOnClickListener(this)
    }


    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v) {
            btn_play -> setIntent()
        }
    }

    private fun setIntent(typeOfIntent: String = "explicit") {
        when(typeOfIntent) {
            "explicit" -> {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                val playerOne = txt_input_player_1.text.toString()
                val playerTwo = txt_input_player_2.text.toString()
                intent.putExtra(SecondActivity.PLAYER_ONE, playerOne)
                intent.putExtra(SecondActivity.PLAYER_TWO, playerTwo)
                startActivity(intent)
            }
            "implicit" -> {
                val imp = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enigmacamp.com/"))
                startActivity(imp)
            }
        }

    }
}