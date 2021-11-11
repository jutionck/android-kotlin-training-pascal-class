package com.example.pascalandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val PLAYER_ONE = "PLAYER_ONE"
        const val PLAYER_TWO = "PLAYER_TWO"
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val playerOne = intent.getStringExtra(PLAYER_ONE)
        textView3.text = "$playerOne's Turn"
        btn_quit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_quit -> finish()
        }
    }

    fun buttonClick(view: android.view.View) {
        val buttonSelected = view as Button
        var value = 0
        //when case button 1..9
        when (buttonSelected.id) {
            R.id.button1 -> value = 1
            R.id.button2 -> value = 2
            R.id.button3 -> value = 3
            R.id.button4 -> value = 4
            R.id.button5 -> value = 5
            R.id.button6 -> value = 6
            R.id.button7 -> value = 7
            R.id.button8 -> value = 8
            R.id.button9 -> value = 9
        }
        playGame(value, buttonSelected)
    }

    @SuppressLint("SetTextI18n")
    private fun playGame(value: Int, buttonSelected: Button) {
        val playerOne = intent.getStringExtra(PLAYER_ONE)
        val playerTwo = intent.getStringExtra(PLAYER_TWO)
        if (activePlayer == 1) {
            textView3.text = "$playerTwo's Turn"
            buttonSelected.text = "X"
            player1.add(value)
            activePlayer = 2
        } else {
            textView3.text = "$playerOne's Turn"
            buttonSelected.text = "O"
            player2.add(value)
            activePlayer = 1
        }
        //disable button, after click
        buttonSelected.isEnabled = false;
        //check winner
        getWinner()
    }

    @SuppressLint("SetTextI18n")
    private fun getWinner() {
        val playerOne = intent.getStringExtra(PLAYER_ONE)
        val playerTwo = intent.getStringExtra(PLAYER_TWO)
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                textView3.text = "$playerOne  win the game"
            } else {
                textView3.text = "$playerTwo  win the game"
            }
        }
    }
}