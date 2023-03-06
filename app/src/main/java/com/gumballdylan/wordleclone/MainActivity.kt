package com.gumballdylan.wordleclone

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setWord()

        //show placeholders as _
        var placeholders = ""
        for (c in randWord){
            placeholders += "_ "
        }

        findViewById<TextView>(R.id.placeholderText).text = placeholders
        val intent = intent
        val greetMsg = "Hello " + intent.getStringExtra("username").toString() + " guess the word!"
        val username = findViewById<TextView>(R.id.greetText)
        username.text = greetMsg
    }

    fun wordCheck(view: View) {
        val guess = findViewById<EditText>(R.id.wordInput).text
        findViewById<TextView>(R.id.guessCorrect).text = guesses.toString()
        fullLogic(guess.toString())
    }

    //words to use
    val words =
        arrayOf<String>("SNARE", "YUPPY", "TEARS", "QUEST", "PIANO", "CREAM", "ROATE", "TRAIN")
    val wordsAm: Int = words.size-1
    val length: Int = 5
    var word = -1
    var randWord = ""
    var guesses = 0
    var corLetters = mutableListOf<Char>()


    //randomly selects which word
    fun getWord(): String {
        word = (0..wordsAm).random()
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

    fun setWord() {
        randWord = getWord()
    }

    fun fullLogic(iWord: String) {
        if (iWord.uppercase(Locale.ROOT).equals(randWord)) {
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_LONG).show()
            reset()
        } else {

            //slightly improved efficiency only using one for loop
            for (c in iWord) {
                if (randWord.contains(c.uppercaseChar())) {
                    if (!corLetters.contains(c.uppercaseChar())) {
                        corLetters.add(c.uppercaseChar())
                    }
                }
            }
//            for (i in 0..4)
//            {
//
//                var letter = iWord.get(i)
//                if (checkLetter(letter,randWord))
//                {
//                    if (!(corLetters.contains(letter)))
//                    {
//                        corLetters.add(letter)
//                    }
//                }
//            }

            if (corLetters.isNotEmpty()) {
                val corLett = corLetters.toString()
                findViewById<TextView>(R.id.currentCorLetters).text = corLett
                if (corLetters.count() == 5) {
                    //right letters but wrong order
                }
            } else {
                findViewById<TextView>(R.id.currentCorLetters).text = "no correct letters yet"
            }
            if (guesses == 4) {
                Toast.makeText(this, "Last Chance", Toast.LENGTH_LONG).show()
            }

            if (guesses == 5) {
                reset()
            }
            guesses += 1
        }


    }

    fun reset() {
        guesses = 0
        randWord = getWord()
        corLetters = mutableListOf<Char>()
    }


}

