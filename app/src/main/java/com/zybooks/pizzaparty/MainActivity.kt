package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil
import android.widget.RadioGroup
/**
 * A group of *Saghar Bahrami*.
 *
 * This class helps the user determine how many pizzas are needed
 * to feed a group of hungry party-goers.
 */

const val SLICES_PER_PIZZA = 8
//MainActivity extends the AppCompatActivity class
class MainActivity : AppCompatActivity() {
//The properties numAttendEditText and numPizzasTextView are declared with
// lateinit to allow the properties to be initialized in onCreate().
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //etContentView() sets the MainActivity's content
        // to the layout in activity_main.xml.
        setContentView(R.layout.activity_main)
       // findViewById() returns an object representing the widget
        // from activity_main.xml that matches the given ID.
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }
//When the user types a number and presses the Calculate button,
// the Android system calls calculateClick().
    fun calculateClick(view: View) {
    //The EditText text getter returns the editable text,
    // and toString() converts the editable text into a string.
        val numAttendStr = numAttendEditText.text.toString()
    //converts the string "5" into the integer 5.
        val numAttend = numAttendStr.toInt()
        // Determine how many slices on average each person will eat
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }
        val totalPizzas = ceil(numAttend * slicesPerPerson /
                SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}