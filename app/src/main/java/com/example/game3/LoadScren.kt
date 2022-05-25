package com.example.game3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadScren : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        Handler().postDelayed({
            val mainact = Intent(this, Mainu::class.java)
            startActivity(mainact)
            finish()
        },3000)
    }
}