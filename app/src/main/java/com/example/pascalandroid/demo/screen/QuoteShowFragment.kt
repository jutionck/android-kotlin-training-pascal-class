package com.example.pascalandroid.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.FragmentQuoteShowBinding
import com.example.pascalandroid.databinding.FragmentQuotesBinding
import com.example.pascalandroid.demo.viewmodel.MessageViewModel


class QuoteShowFragment : Fragment() {

    private lateinit var binding: FragmentQuoteShowBinding
    private lateinit var messageViewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuoteShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel = ViewModelProvider(requireActivity())[MessageViewModel::class.java]
        // Using dataBinding to bind data directly to the views in XML
        binding.quotesViewModel = messageViewModel
        binding.lifecycleOwner = this

        // Ini sudah tidak di pakai kembali karena sudah menggunakan dataBinding
        //subscribe()
    }

//    private fun subscribe() {
//        messageViewModel.message.observe(viewLifecycleOwner, {
//            binding.tvQuote.text = it
//        })
//    }
}