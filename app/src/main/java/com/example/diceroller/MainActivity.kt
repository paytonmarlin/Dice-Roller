package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        val diceOneRoll = dice.roll() //calls the roll method, which returns a random number
        val diceTwoRoll = dice.roll()
//        val resultTextView1: TextView =
//            findViewById(R.id.dice1) //finds the view by ID and stores it in variable
//        resultTextView1.text = "Dice #1 rolled ${diceOneRoll.toString()}" //changes the text to result the dice roll
//
//        val resultTextView2: TextView =
//            findViewById(R.id.dice2) //finds the view by ID and stores it in variable
//        resultTextView2.text = "Dice #2 rolled ${diceTwoRoll.toString()}" //changes the text to result the dice roll

        val diceImage1: ImageView = findViewById(R.id.DiceImage1)
        val diceImage2: ImageView = findViewById(R.id.DiceImage2)

        /**
         * Instead of doing
         * when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

         This would be better...
         */
        val drawableResource1 = when (diceOneRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1) //reduced redundancy in when clause
        diceImage1.contentDescription = diceOneRoll.toString() //accessibility for screen readers

        val drawableResource2 = when (diceTwoRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource2) //reduced redundancy in when clause
        diceImage2.contentDescription = diceTwoRoll.toString() //accessibility for screen readers
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}