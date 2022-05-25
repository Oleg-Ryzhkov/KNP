package com.example.game3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Scare : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scare)

        val rest = findViewById<Button>(R.id.button)
        val rsalt = findViewById<TextView>(R.id.resalt)


        val arguments = intent.extras
        val odo = arguments!!["int"].toString()
        rsalt.text = "Wins = "+ odo
        rest.setOnClickListener() {
            val Resta = Intent(this, gomer::class.java)
            startActivity(Resta)
            finish()
        }
    }
}