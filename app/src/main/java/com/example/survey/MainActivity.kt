package com.example.survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val PALESTINE_COUNT_KEY = "palestine-count-bundle-key"
const val ISRAEL_COUNT_KEY = "israel-count-bundle-key"

class MainActivity : AppCompatActivity() {

    lateinit var palestineButton: Button
    lateinit var israelButton: Button
    lateinit var palestineCount: TextView
    lateinit var israelCount: TextView
    lateinit var clearCount: Button
//Declare globals and locals for keys, components, and view model
    private val palestinianConflictViewModel: PalestinianConflictViewModel by lazy {
        ViewModelProvider(this).get(PalestinianConflictViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        palestineButton = findViewById(R.id.palestine_button)
        israelButton = findViewById(R.id.israel_button)
        palestineCount = findViewById(R.id.palestine_count)
        israelCount = findViewById(R.id.israel_count)
        clearCount = findViewById(R.id.clear_button)
// Set up your onCreate views, clickListeners, and call the update functions to have the current counts in the TextViews
        palestineButton.setOnClickListener {
            addPalestine()
        }

        israelButton.setOnClickListener {
            addIsrael()
        }

        clearCount.setOnClickListener {
            palestinianConflictViewModel.clearCount()
            updatePalestineCount()
            updateIsraelCount()
        }

        updateIsraelCount()
        updatePalestineCount()
    }

    private fun addPalestine() {
        palestinianConflictViewModel.addPalestine()
        updatePalestineCount()
    }
//Make functions for adding to the count in the ViewModel and to update the count from the ViewModel
    private fun updatePalestineCount() {
        val pCount = palestinianConflictViewModel.getPalestine()
        val pCountDisplay = pCount.toString()
        palestineCount.text = pCountDisplay
    }


    private fun addIsrael() {
        palestinianConflictViewModel.addIsrael()
        updateIsraelCount()
    }

    private fun updateIsraelCount() {
        val iCount = palestinianConflictViewModel.getIsrael()
        val iCountDisplay = iCount.toString()
        israelCount.text = iCountDisplay
    }
}