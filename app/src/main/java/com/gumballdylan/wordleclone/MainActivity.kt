package com.gumballdylan.wordleclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun updateName(view: View) {
        val textView = findViewById<TextView>(R.id.txt)
        val inputText = findViewById<EditText>(R.id.textInput)
        textView.text = "Hello " + inputText.text
    }
}