package com.example.pascalandroid.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel: ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val messageQuotes = listOf<String>(
        "Have nice day",
        "Never give up",
        "Keep working hard",
        "Keep your study"
    )
    private val index = (0..3).random()
    private val currentMessageQuote = messageQuotes[index]

    fun sendMessage(name: String) {
        _message.value = "Selamat Sore $name!\n $currentMessageQuote"
    }

    override fun onCleared() {
        super.onCleared()
    }
}