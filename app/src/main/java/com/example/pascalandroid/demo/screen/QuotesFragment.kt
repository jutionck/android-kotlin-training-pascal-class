package com.example.pascalandroid.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.FragmentQuotesBinding
import com.example.pascalandroid.demo.viewmodel.MessageViewModel

class QuotesFragment : Fragment() {

    private lateinit var binding: FragmentQuotesBinding
    private lateinit var messageViewModel: MessageViewModel
    private lateinit var fragmentQuoteShow: QuoteShowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel = ViewModelProvider(requireActivity())[MessageViewModel::class.java]
        fragmentQuoteShow = QuoteShowFragment()
        binding.apply {
            btnSendQuote.setOnClickListener {
                messageViewModel
                    .sendMessage(teFullName.text.toString())
                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_greeting, fragmentQuoteShow)
                    .commit()
            }
        }
    }
}