package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    private lateinit var playerOne: EditText
    private lateinit var playerTwo: EditText
    private lateinit var start: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        playerOne = findViewById(R.id.player1)
        playerTwo = findViewById(R.id.player2)
        start = findViewById(R.id.start)

        start.setOnClickListener {

            val first = playerOne.text.toString()
            val second = playerTwo.text.toString()

            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("FIRST", first)
            intent.putExtra("SECOND", second)

            if(first.isNotEmpty() && second.isNotEmpty()){

            startActivity(intent)

            }
            else if (first.isEmpty() || second.isEmpty()) {
                Toast.makeText(this, "ENTER PLAYER NAMES!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}