package com.example.pascalandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.FragmentBlockVolumeShowBinding

class BlockVolumeShowFragment : Fragment() {

    private var _binding: FragmentBlockVolumeShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBlockVolumeShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun getCalculateBlockVolume(result: Double) {
        binding.tvBlockShowVolume.text = result.toString()
    }

}