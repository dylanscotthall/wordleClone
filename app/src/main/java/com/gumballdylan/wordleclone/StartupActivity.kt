package com.gumballdylan.wordleclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class StartupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
    }

    fun updateName(view: View) {
        //receive name from input text and displays it in text view
        val textView = findViewById<TextView>(R.id.txt)
        val inputText = findViewById<EditText>(R.id.textInput)
        textView.text = "Hello " + inputText.text

        //toast message to show name inputed
        val toast = Toast.makeText(applicationContext, textView.text, Toast.LENGTH_LONG)
        toast.setMargin(50f, 50f)
        toast.show()

        // intent to go to mainActivity for our game
        val i = Intent(this@StartupActivity, MainActivity::class.java)
        i.putExtra("username", inputText.text.toString())
        startActivity(i)
    }
}