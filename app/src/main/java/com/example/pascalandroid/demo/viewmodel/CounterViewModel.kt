package com.example.pascalandroid.demo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    init {
        Log.i("test", "CounterViewModel created")
    }

    // Communicate between fragment -> shareViewModels
    var counter = MutableLiveData<Int>()
    private var _counter = 0
    fun notifyIncrease() {
        _counter++
        counter.value = _counter
        Log.i("test", "notifyIncrease: ${counter.value}")
    }

    fun notifyDecrease() {
        _counter--
        counter.value = _counter
        Log.i("test", "notifyDecrease: ${counter.value}")
    }

    // lifecycle ViewModels
    override fun onCleared() {
        super.onCleared()
        Log.i("test", "CounterViewModel cleared")
    }
}