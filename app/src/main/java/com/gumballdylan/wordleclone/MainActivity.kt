package com.gumballdylan.wordleclone

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val str = intent.getStringExtra("username").toString()
        Log.d("str", str)
        val username = findViewById<TextView>(R.id.textUsername)
        username.setText(str)
    }
}