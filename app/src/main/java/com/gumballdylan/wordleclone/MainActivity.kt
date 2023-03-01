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
    var word=-1
    var randWord=""
    var guesses=0

    //randomly selects which word
    fun getWord():String
    {
        word=(0..wordsAm).random()
        return words[word]
    }




    //checks if the letter is in the word and if it has already been used
    fun checkLetter(c:Char,word:String ):Boolean
    {
        for (i in 0..4)
        {
            if (word.get(i)==(c))
            {
                return true
            }
        }


          return false

    }

    fun setWord()
    {
        randWord=getWord()
    }

    fun fullLogic(iWord:String,)
    {
       guesses+1
        if (iWord.equals(randWord))
        {
            //display correct word output or whatever
        }
        else
        {

            var corLetters = mutableListOf<Char>()

            for (i in 0..4)
            {

                var letter = iWord.get(i)
                if (checkLetter(letter,randWord))
                {
                    if (!(corLetters.contains(letter)))
                    {
                        corLetters.add(letter)
                    }
                }

            }

            if (corLetters.isNotEmpty())
            {
                //return the letters from corletters and say they are correct
                if (corLetters.count()==5)
                {
                    //right letters but wrong order
                }
            }
            else
            {
                //output for incorrect letters
            }
            if (guesses==4)
            {
                //display that it is the last guess

            }

            if ( guesses==5)
            {
                //lock out user and end screen
            }
        }


    }

    fun reset()
    {
        guesses=0
        setWord();
    }


}

