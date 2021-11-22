package com.example.pascalandroid.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.databinding.FragmentCounterBinding
import com.example.pascalandroid.demo.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
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
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterViewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        binding.apply {
            btnIncrement.setOnClickListener {
                counterViewModel.notifyIncrease()
            }

            btnDecrement.setOnClickListener {
                counterViewModel.notifyDecrease()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}