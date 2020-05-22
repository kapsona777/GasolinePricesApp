package com.example.goapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        login_button.setOnClickListener{
            if (email_field.text.toString() == "lasha.kapanadze.1@btu.edu.ge" && password_field.text.toString() == "kapsona") {
                openActivePage()
            }
            else {Toast.makeText(this,"ინფორმაცია არასწორია!",Toast.LENGTH_LONG).show()}
        }
    }

    private fun openActivePage(){
        val intent = Intent(this, ActivePage::class.java)
        startActivity(intent)
    }
}
