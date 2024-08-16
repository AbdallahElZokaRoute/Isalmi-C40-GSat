package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0
    private var currentZekrIndex = 0
    private val zekr = arrayOf("سبحان الله", "الحمد لله", "الله اكبر", "لا اله الا الله", "استغفر الله")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_sebha) // Use the correct activity layout

        // Find the button and text view by their IDs
        val btn: Button = findViewById(R.id.btn)
        val txt: TextView = findViewById(R.id.azkar)
        val radioIcn: ImageView = findViewById(R.id.radio)
        val sebhaIcn: ImageView = findViewById(R.id.sebha)
        val hadeethIcn: ImageView = findViewById(R.id.hadith)
        val quranIcn: ImageView = findViewById(R.id.quran)

        // Initialize the TextView with the current zekr
        updateZekrText(txt)

        // Set up the button click listener
        btn.setOnClickListener {
            onButtonClick(btn, txt)
        }

        // Set up the ImageView click listener for 'radioIcn'
        radioIcn.setOnClickListener {
            val fragment = FragmentRadio()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment) // Ensure this is the correct ID
                .addToBackStack(null)
                .commit()
        }

        // Set up the ImageView click listener for 'sebhaIcn'
        sebhaIcn.setOnClickListener {
            val fragment2 = FragmentSebha()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment2) // Ensure this is the correct ID
                .addToBackStack(null)
                .commit()
        }
    }

    // Function to update the TextView with the current zekr
    private fun updateZekrText(txt: TextView) {
        txt.text = zekr[currentZekrIndex]
    }

    // Function to handle button click logic
    private fun onButtonClick(btn: Button, txt: TextView) {
        count++
        if (count >= 30) {
            count = 0
            currentZekrIndex = (currentZekrIndex + 1) % zekr.size
            updateZekrText(txt)
        }
        btn.text = count.toString()
    }
}
