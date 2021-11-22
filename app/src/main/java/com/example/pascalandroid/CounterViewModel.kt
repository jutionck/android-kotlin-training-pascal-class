package com.example.pascalandroid

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    init {
        Log.i("test", "CounterViewModel created")
    }

    var counter = MutableLiveData<Int>()
    private var _counter = 0
    fun notifyIncrease() {
        _counter++
        counter.value = _counter
        Log.i("test", "notifyIncrease: ${counter.value}")
    }

    // lifecycle ViewModels
    override fun onCleared() {
        super.onCleared()
        Log.i("test", "CounterViewModel cleared")
    }
}