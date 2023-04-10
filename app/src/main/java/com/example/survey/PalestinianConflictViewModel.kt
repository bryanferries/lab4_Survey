package com.example.survey

import androidx.lifecycle.ViewModel

class PalestinianConflictViewModel: ViewModel() {

//Create variables for each count
    private var palestineCount = 0
    private var israelCount = 0
//Create functions to add to each count and return each int
    fun addPalestine() {
        palestineCount++
    }

    fun getPalestine(): Int {
        return palestineCount
    }

    fun addIsrael() {
        israelCount++
    }

    fun getIsrael(): Int {
        return israelCount
    }
//Create a function to clear the count by setting each equal to zero
    fun clearCount() {
        palestineCount = 0
        israelCount = 0
    }
}