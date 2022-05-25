package com.example.game3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Mainu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainu)

        val starta = findViewById<Button>(R.id.starta)
        val Exit = findViewById<Button>(R.id.Exaty)

        starta.setOnClickListener() {
            val mainact = Intent(this, gomer::class.java)
            startActivity(mainact)
            finish()
        }
        Exit.setOnClickListener(){
            finish()
        }
    }
}