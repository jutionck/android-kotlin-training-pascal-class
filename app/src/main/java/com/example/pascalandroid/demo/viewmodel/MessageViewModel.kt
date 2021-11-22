package com.example.pascalandroid.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel: ViewModel() {

    var message = MutableLiveData<String>()

    private val messageQuotes = listOf<String>(
        "Have nice day",
        "Never give up",
        "Keep working hard",
        "Keep your study"
    )
    private val index = (0..3).random()
    private val currentMessageQuote = messageQuotes[index]

    fun sendMessage(name: String) {
        message.value = "Selamat Sore $name!\n $currentMessageQuote"
    }
}