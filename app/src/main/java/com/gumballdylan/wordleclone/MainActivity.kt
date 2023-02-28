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

    //words to use
    val words=arrayOf<String>("SNARE", "YUPPY","TEARS", "QUEST", "PIANO", "CREAM", "ROATE","TRAIN")
    val wordsAm:Int=7
    var length=0
    var word=-1
    var letters=  mutableListOf<String>()
    //randomly selects which word
    fun getWord():String
    {
        word=(0..wordsAm).random()
        length=words[word].length
        return words[word]
    }




    //checks if the letter is in the word and if it has already been used
    fun checkLetter(c:String,word:String ):Boolean
    {
        if (letters.contains(c))
        {
            //use on ui for already used letter
            return false
        }
        else
        {
            letters.add(c)
            return word.contains(c,ignoreCase = true)
        }
    }

    fun fullLogic()
    {
        //get word
        //display word length but hidden letters  UI
        //allow user input  UI
        //check if letter is in word
        //add letter to list of used letters
        //display correct or incorrect  UI
        //show letter block  UI
        // and then show word at end UI
        //allow a reset and retry

    }



}

