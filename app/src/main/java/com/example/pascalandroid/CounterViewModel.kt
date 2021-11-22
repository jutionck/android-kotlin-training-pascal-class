package com.example.pascalandroid

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    init {
        Log.i("test", "CounterViewModel created")
    }

    var counter = 0
    fun notifyIncrease() {
        counter++
    }

    // lifecycle ViewModels
    override fun onCleared() {
        super.onCleared()
        Log.i("test", "CounterViewModel cleared")
    }
}