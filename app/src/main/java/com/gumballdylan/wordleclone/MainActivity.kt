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
        for (c in randWord){
            placeholders += "_ "
        }

        findViewById<TextView>(R.id.placeholderText).text = placeholders
        val intent = intent
        val greetMsg = "Hello " + intent.getStringExtra("username").toString() + " guess the word!"
        val username = findViewById<TextView>(R.id.greetText)
        username.text = greetMsg
        findViewById<TextView>(R.id.guessCorrect).text = guesses.toString()
    }

    fun wordCheck(view: View) {
        val guess = findViewById<EditText>(R.id.wordInput).text
        fullLogic(guess.toString())
        findViewById<TextView>(R.id.guessCorrect).text = guesses.toString()

    }

    //words to use
    var placeholders=""
    val words =
        arrayOf<String>("SNARE", "YUPPY", "TEARS", "QUEST", "PIANO", "CREAM", "ROATE", "TRAIN")
    val wordsAm: Int = words.size-1
    var word = -1
    var randWord = ""
    var guesses = 0
    var corLetters = mutableListOf<Char>()
    var inCorLetters= mutableListOf<Char>()


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
            return
        } else {

            //slightly improved efficiency only using one for loop
            for (c in iWord) {
                if (randWord.contains(c.uppercaseChar())) {
                    if (!corLetters.contains(c.uppercaseChar())) {
                        corLetters.add(c.uppercaseChar())
                    }
                }
                else
                {
                    if (!inCorLetters.contains(c.uppercaseChar())) {
                        inCorLetters.add(c.uppercaseChar())
                    }
                }
            }

            revealLetters(corLetters)
            findViewById<TextView>(R.id.placeholderText).text = placeholders



            if (corLetters.isNotEmpty()) {
                val corLett = corLetters.toString()
                val inlet=inCorLetters.toString()
                findViewById<TextView>(R.id.currentCorLetters).text = corLett

                if (corLetters.count() == 5) {
                    findViewById<TextView>(R.id.currentCorLetters).text = "All letters are correct Type in the correct word to win"
                }
                else
                {
                    findViewById<TextView>(R.id.currentIncorLetters).text = inlet
                }
            }
            else {
                findViewById<TextView>(R.id.currentCorLetters).text = "no correct letters yet"
            }
            if (guesses == 4) {
                Toast.makeText(this, "Last Chance to guess", Toast.LENGTH_LONG).show()
            }

            if (guesses == 5) {
                reset()
                Toast.makeText(this, "You've Lost the Game: Resetting with new word", Toast.LENGTH_LONG).show()

            }
            guesses += 1
        }


    }

    fun reset() {
        guesses = 0
        findViewById<TextView>(R.id.guessCorrect).text = guesses.toString()
        randWord = getWord()
        placeholders=""
        for (c in randWord){
            placeholders += "_ "
        }
        findViewById<TextView>(R.id.placeholderText).text = placeholders

        corLetters = mutableListOf<Char>()
        findViewById<TextView>(R.id.currentCorLetters).text ="[]"
        inCorLetters=mutableListOf<Char>()
        findViewById<TextView>(R.id.currentIncorLetters).text="[]"
    }


    fun revealLetters(letters:List<Char> )
    {
        var wordSpaced=randWord
        wordSpaced=wordSpaced
            .subSequence(0, wordSpaced.length)
            .chunked(1)
            .joinToString(" ")
        for (c in letters)
        {
            var index = wordSpaced.indexOf(c,ignoreCase = true)
            while (index != -1)
            {
                placeholders=placeholders.replaceRange(index,index+1,""+c)
                //placeholders=placeholders.take(index)+c+placeholders.drop(index+1);
                index = wordSpaced.indexOf(c, index + 1,ignoreCase = true)
            }

        }
    }

}

