# Dice Roller App 
This is the next app which implements a dice rolling simulation. I have gotten to play more with Kotlin and the views that make up the user-interface
---
## What I learned
In the (**app > java > MainActivity.kt**) file, I got to see what happens when the app first starts up. 

```kotlin
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
```

The MainActivity class starts when the user opens up the application.\

---

A *Button* view doesn't have any default actions when pressed, so that is why we need a **setOnClickListener** activity which will have our actions when the button is clicked.
---
A *Toast* is a little notification that pops up at the bottom of an android screen, this is useful for debugging and developing.
---

## If, Else, When
Since I already know what If and Else statements are, I am not going to put anything that I learned. However, during a tutorial, I found the *When* keyword in Kotlin interesting. It seems to be like a 'Switch Case' that has a default value if a case is met, but has other values if a case is not met.

For instance, let's take a dice game:
```kotlin
fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
   }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
```
The **When** case passes in the rollResult, which is different every time that the program is ran. So, when the rollResult = the luckyNumber, we will print out to the user that they have won!

But if the rollResult equals a 1, 2, 3, 5, or 6 then we will print out different lines depending on what the roll is.

In conclusion, the when keyword compares the value passed (in this case it is the rollResult) to the 'cases'.