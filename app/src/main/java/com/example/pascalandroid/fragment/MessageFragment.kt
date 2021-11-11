package com.example.pascalandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.R
import com.example.pascalandroid.contoller.MessageController
import kotlinx.android.synthetic.main.fragment_message.view.*

class MessageFragment : Fragment() {

    private lateinit var messageController: MessageController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_message, container, false)
        messageController = activity as MessageController
        view.btn_greeting.setOnClickListener {
            val messageGreeting = listOf<String>("Have nice day", "Never give up", "Keep working hard", "Keep your study", "Happy Great Days")
            val index = (0..4).random()
            val currentMessageGreeting = messageGreeting[index]
            val message = "${view.txt_input_name.text.toString()}! $currentMessageGreeting"
            messageController.sendMessage(message)
        }
        return view
    }
}