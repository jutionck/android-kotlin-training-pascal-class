package com.example.pascalandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.activity.MainActivity
import com.example.pascalandroid.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
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
//        binding.btnIncrement.setOnClickListener {
//            mainActivity.notifyIncrease()
//        }
//
//        binding.btnDecrement.setOnClickListener {
//            mainActivity.notifyDecrease()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}