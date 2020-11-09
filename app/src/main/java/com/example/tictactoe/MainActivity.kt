package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID: String = ""
        when (buSelected.id) {
            R.id.button00 -> cellID = "00"
            R.id.button01 -> cellID = "01"
            R.id.button02 -> cellID = "02"
            R.id.button10 -> cellID = "10"
            R.id.button11 -> cellID = "11"
            R.id.button12 -> cellID = "12"
            R.id.button20 -> cellID = "20"
            R.id.button21 -> cellID = "21"
            R.id.button22 -> cellID = "22"
        }

//        Toast.makeText(this, "Cell ID: "+ cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, buSelected)
    }

    var player1 = ArrayList<String>()
    var player2 = ArrayList<String>()

    var activePlayer = 1
    private fun playGame(cellID: String, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X"
            player1.add(cellID)
            activePlayer = 2
        } else {
            buSelected.text = "O"
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner(buSelected)
    }

    private fun checkWinner(view: View) {
        var winner = -1

        // row1 check
        if (player1.contains("00") && player1.contains("01") && player1.contains("02")) {
            winner = 1
        }
        if (player2.contains("00") && player2.contains("01") && player2.contains("02")) {
            winner = 2
        }

        // row2 check
        if (player1.contains("10") && player1.contains("11") && player1.contains("12")) {
            winner = 1
        }
        if (player2.contains("10") && player2.contains("11") && player2.contains("12")) {
            winner = 2
        }

        // row3 check
        if (player1.contains("20") && player1.contains("21") && player1.contains("22")) {
            winner = 1
        }
        if (player2.contains("20") && player2.contains("21") && player2.contains("22")) {
            winner = 2
        }

        // col1 check
        if (player1.contains("00") && player1.contains("10") && player1.contains("20")) {
            winner = 1
        }
        if (player2.contains("00") && player2.contains("10") && player2.contains("20")) {
            winner = 2
        }

        //col2 check
        if (player1.contains("01") && player1.contains("11") && player1.contains("21")) {
            winner = 1
        }
        if (player2.contains("01") && player2.contains("11") && player2.contains("21")) {
            winner = 2
        }

        // col3 check
        if (player1.contains("02") && player1.contains("12") && player1.contains("22")) {
            winner = 1
        }
        if (player2.contains("02") && player2.contains("12") && player2.contains("22")) {
            winner = 2
        }

        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, "Player1 is winner", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player2 is winner", Toast.LENGTH_LONG).show()
            }

            findViewById<Button>(R.id.button00).isEnabled = false
            findViewById<Button>(R.id.button01).isEnabled = false
            findViewById<Button>(R.id.button02).isEnabled = false
            findViewById<Button>(R.id.button10).isEnabled = false
            findViewById<Button>(R.id.button11).isEnabled = false
            findViewById<Button>(R.id.button12).isEnabled = false
            findViewById<Button>(R.id.button20).isEnabled = false
            findViewById<Button>(R.id.button21).isEnabled = false
            findViewById<Button>(R.id.button22).isEnabled = false

        }

    }
}