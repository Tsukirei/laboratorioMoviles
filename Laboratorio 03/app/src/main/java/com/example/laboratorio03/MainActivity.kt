package com.example.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

lateinit var moneyCountText: TextView
lateinit var fiveCentsImg: ImageView
lateinit var tenCentsImg: ImageView
lateinit var quarteImg: ImageView
lateinit var dolarImg: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        action()
    }

    private fun bind(){
        moneyCountText= findViewById(R.id.moneyCounter)
        fiveCentsImg= findViewById(R.id.fiveCentsImage)
        tenCentsImg= findViewById(R.id.tenCentsImage)
        quarteImg= findViewById(R.id.quarterImage)
        dolarImg= findViewById(R.id.dollarImage)
    }

    private fun action(){

        fiveCentsImg.setOnClickListener(){
           plusMoney(0.05)

        }
        tenCentsImg.setOnClickListener(){
            plusMoney(0.10)
        }
        quarteImg.setOnClickListener(){
            plusMoney(0.25)
        }
        dolarImg.setOnClickListener(){
            plusMoney(1.00)
        }

    }
    private fun plusMoney(actualValue: Double) {
        var counterModified: Double
        counterModified= moneyCountText.text.toString().toDouble()
        counterModified = (counterModified + actualValue).toDouble()
        counterModified = (counterModified * 100.0).roundToInt() / 100.0

        moneyCountText.text = counterModified.toString()


    }
}