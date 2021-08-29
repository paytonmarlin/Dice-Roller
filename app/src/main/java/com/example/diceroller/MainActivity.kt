package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity :
    AppCompatActivity() { //This will run when the app is opened, calls the onCreate() method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //set the main layout when the app is opened

        val rollButton: Button =
            findViewById(R.id.button) //finds the button in layout by a 'Resource ID' in the form of R.<type>.<name>
        rollButton.setOnClickListener { //this 'listens' until the button is clicked or pressed
//            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT) //a short message is shown (like a notification)
//            toast.show()

            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show() can condense into one line

//            val resultTextView: TextView = findViewById(R.id.textView) //this finds the text view
//            resultTextView.text = "6" //and will change it to be 6 after button is pressed

            rollButton.setOnClickListener {
                rollDice() //calls the rollDice() function
            }
        }
    }

    private fun rollDice() {
        val dice = Dice(6) //initiates instance of the Dice class
        val diceRoll = dice.roll() //calls the roll method, which returns a random number
        val resultTextView: TextView =
            findViewById(R.id.textView) //finds the view by ID and stores it in variable
        resultTextView.text = diceRoll.toString() //changes the text to result the dice roll
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}