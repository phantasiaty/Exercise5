package com.example.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    //Module-level variable
    var countLike: Int = 0
    var countDislike: Int = 0

    init {
        Log.i("CountViewModel", "CountViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("CountViewModel", "CountViewModel destroyed!")
    }
}