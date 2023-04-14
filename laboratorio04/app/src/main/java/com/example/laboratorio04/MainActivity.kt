package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

lateinit var saveButton: Button
lateinit var inputTextName: EditText
lateinit var inputTextMail: EditText
lateinit var inputTextPhone: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        action()
    }

    fun bind() {
        saveButton = findViewById(R.id.saveButton)
        inputTextName= findViewById(R.id.textInputName)
        inputTextMail = findViewById(R.id.textInputMail)
        inputTextPhone = findViewById(R.id.textInputPhone)
    }

    fun action() {
        saveButton.setOnClickListener(){
            var userName = inputTextName.text.toString()
            var userMail = inputTextMail.text.toString()
            var userPhone = inputTextPhone.text.toString()
            val intent = Intent(this, SecondActivity::class.java )
            intent.putExtra("Name", userName)
            intent.putExtra("Mail", userMail)
            intent.putExtra("Phone", userPhone)
            startActivity(intent)
        }
    }
}