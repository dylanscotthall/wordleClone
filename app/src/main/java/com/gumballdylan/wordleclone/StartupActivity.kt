package com.gumballdylan.wordleclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class StartupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
    }

    fun updateName(view: View) {
        val textView = findViewById<TextView>(R.id.txt)
        val inputText = findViewById<EditText>(R.id.textInput)
        textView.text = "Hello " + inputText.text
        val i = Intent(this@StartupActivity, MainActivity::class.java)
        i.putExtra("username", inputText.text.toString());
        startActivity(i)
    }
}