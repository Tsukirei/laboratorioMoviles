package com.example.laboratorio04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.util.jar.Attributes.Name

lateinit var textName: TextView
lateinit var textMail: TextView
lateinit var textPhone: TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bind()
        action()
    }

    fun bind(){
        textName = findViewById(R.id.textNameInformationUser)
        textMail = findViewById(R.id.textMailInformationUser)
        textPhone = findViewById(R.id.textPhoneInformationUser)
    }
    fun action(){
        textName.text = intent.getStringExtra("Name").toString()
        textMail.text= intent.getStringExtra("Mail").toString()
        textPhone.text  = intent.getStringExtra("Phone").toString()



    }


}