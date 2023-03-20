package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var resultTextOne: TextView
    private lateinit var resultTextTwo: TextView
    private lateinit var resultTextThree: TextView
    private lateinit var buttonCalculator: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()
        change()
    }
    private fun binding(){
        editTextWeight=findViewById(R.id.editTextWeight)
        editTextHeight=findViewById(R.id.editTextHeight)
        resultTextOne=findViewById(R.id.resultText1)
        resultTextTwo=findViewById(R.id.resultText2)
        resultTextThree=findViewById(R.id.resultText3)
        buttonCalculator=findViewById(R.id.calculateButton)
    }
    private fun change(){
         var firtsResult : Float

        buttonCalculator.setOnClickListener(){
            firtsResult =
                editTextWeight.text.toString().toFloat() /
                        ((editTextHeight.text.toString().toFloat().pow(2))/10000)

                            resultTextOne.text=firtsResult.toString()
            resultTextThree.text= "Normal BMI is around 18.5 - 24.99"
            if(firtsResult <= 18.5){
                resultTextTwo.text="Underweight"

            }
            else if(18.5<firtsResult && firtsResult<=24.99){
                resultTextTwo.text= "Healthy"

            }
            else if( 25 < firtsResult && firtsResult<=29.99){
                resultTextTwo.text="Overweight"
            }
            else if(firtsResult>=30){
                resultTextTwo.text="Obese"
            }
        }

    }
}


