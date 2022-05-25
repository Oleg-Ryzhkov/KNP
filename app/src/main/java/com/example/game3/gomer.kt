package com.example.game3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class gomer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gomer)

        val player = findViewById<ImageView>(R.id.player)
        val allias = findViewById<ImageView>(R.id.allias)
        val firsthand =  findViewById<ImageView>(R.id.firsthand)
        val twohand = findViewById<ImageView>(R.id.twohand)
        val threhand = findViewById<ImageView>(R.id.threhand)
        val result = findViewById<TextView>(R.id.Result)
        val alliashand = arrayOf(R.drawable.kamenright, R.drawable.nojright, R.drawable.bumright)
        var randomall = 3
        val score = findViewById<TextView>(R.id.score)
        var scoreint = 0
        val gameover = Intent(this, Scare::class.java)
        fun gameover(){
            Log.e("drawa" , "$scoreint")
            gameover.putExtra("int", "" + scoreint)
            Handler().postDelayed({
                startActivity(gameover)
                finish()
            },1000)

        }
        fun game(){
           randomall = (0..2).random()
            Handler().postDelayed({
            allias.setImageResource(alliashand[randomall])
            },1500)
        }
        fun restart(){
            Handler().postDelayed({
                firsthand.isClickable = true
                twohand.isClickable = true
                threhand.isClickable = true
            },1500)
            randomall = 3
            player.setImageResource(R.drawable.shos)
            allias.setImageResource(R.drawable.shos)
            result.text = ""

        }

        firsthand.setOnClickListener(){
            firsthand.isClickable =false
            twohand.isClickable = false
            threhand.isClickable = false
            player.setImageResource(R.drawable.kamenleft)
            game()
            Handler().postDelayed({
             if (randomall == 0)
             {
                 result.text = "Nobody Wins"
                 Handler().postDelayed({
                     restart()
                 }, 1500)
             }
                else if (randomall == 1){
                    result.text = "You Won"
                 scoreint++
                 score.text = "Wins = " +scoreint
                 Handler().postDelayed({
                     restart()
                 }, 1500)
             }
             else if (randomall == 2){
                 result.text = "You Lose"
                 Handler().postDelayed({
                     gameover()
                 }, 1500)
             }
            },1500)
        }
        twohand.setOnClickListener(){
            firsthand.isClickable = false
            twohand.isClickable = false
            threhand.isClickable = false
            player.setImageResource(R.drawable.nojleft)
            game()
            Handler().postDelayed({
                if (randomall == 0)
                {
                    result.text = "You Lose"
                    Handler().postDelayed({
                        gameover()
                    }, 1500)
                }
                else if (randomall == 1){
                    result.text = "Nobody Wins"
                    Handler().postDelayed({
                        restart()
                    }, 1500)
                }
                else if (randomall == 2){
                    result.text = "You Won"
                    scoreint++
                    score.text = "Wins = " +scoreint
                    Handler().postDelayed({
                        restart()
                    }, 1500)
                }
            },1500)
        }
        threhand.setOnClickListener(){
            firsthand.isClickable = false
            twohand.isClickable = false
            threhand.isClickable = false
            player.setImageResource(R.drawable.bumleft)
            game()
            Handler().postDelayed({
                if (randomall == 0)
                {
                    result.text = "You Won"
                    scoreint++
                    score.text = "Wins = " +scoreint
                    Handler().postDelayed({
                        restart()
                    }, 1500)
                }
                else if (randomall == 1){
                    result.text = "You Lose"
                    Handler().postDelayed({
                        gameover()
                    }, 1500)
                }
                else if (randomall == 2){

                    result.text = "Nobody Wins"
                    Handler().postDelayed({
                        restart()
                    }, 1500)
                }
            },1500)
        }


    }
}