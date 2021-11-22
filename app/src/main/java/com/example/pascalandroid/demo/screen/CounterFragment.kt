package com.example.pascalandroid.demo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.databinding.FragmentCounterBinding
import com.example.pascalandroid.demo.viewmodel.CounterVIewModel

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
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
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterVIewModel = ViewModelProvider(requireActivity()).get(CounterVIewModel::class.java)
        binding.apply {
            btnIncrement.setOnClickListener {
                counterVIewModel.notifyIncrease()
            }

            btnDecrement.setOnClickListener {
                counterVIewModel.notifyDecrease()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}