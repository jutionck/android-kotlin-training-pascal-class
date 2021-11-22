package com.example.pascalandroid.demo.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.databinding.FragmentCounterShowBinding
import com.example.pascalandroid.demo.viewmodel.CounterVIewModel

class CounterShowFragment : Fragment() {

    private var _binding: FragmentCounterShowBinding? = null
    private val binding get() = _binding!!

    private lateinit var counterVIewModel: CounterVIewModel


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
        counterVIewModel = ViewModelProvider(requireActivity()).get(CounterVIewModel::class.java)
        binding.tvCounter.text = counterVIewModel.counter.toString()
        Log.i("test", "counterViewModel.counter: ${counterVIewModel.counter}")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}