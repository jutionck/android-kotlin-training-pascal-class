package com.example.pascalandroid.demo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterVIewModel: ViewModel() {

    var counter: Int = 0

    fun notifyIncrease() {
        counter++
        Log.i("test", "notifyIncrease: $counter")
    }

    fun notifyDecrease() {
        counter--
        Log.i("test", "notifyDecrease: $counter")
    }
}