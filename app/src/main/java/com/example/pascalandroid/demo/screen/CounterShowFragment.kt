package com.example.pascalandroid.demo.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.databinding.FragmentCounterShowBinding
import com.example.pascalandroid.demo.viewmodel.CounterViewModel

class CounterShowFragment : Fragment() {

    private var _binding: FragmentCounterShowBinding? = null
    private val binding get() = _binding!!
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentCounterShowBinding.inflate(inflater, container, false)
        Log.i("test", "onCreateView() called $_binding")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterViewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        counterViewModel.counter.observe(requireActivity(), {
            binding.tvCounter.text = it.toString()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}