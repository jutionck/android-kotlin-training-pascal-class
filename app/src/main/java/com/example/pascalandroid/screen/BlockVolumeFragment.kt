package com.example.pascalandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pascalandroid.MainActivity
import com.example.pascalandroid.communicator.BlockVolumeCommunicator
import com.example.pascalandroid.databinding.FragmentBlockVolumeBinding

class BlockVolumeFragment : Fragment() {

    private var _binding: FragmentBlockVolumeBinding? = null
    private val binding get() = _binding!!
    private lateinit var blockVolumeCommunicator: BlockVolumeCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blockVolumeCommunicator = activity as BlockVolumeCommunicator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentBlockVolumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalculate.setOnClickListener {
            blockVolumeCommunicator.calculate()
        }
    }

    fun calculateBlockVolume(): Double {
        val length = binding.blockLength.text.toString()
        val width = binding.blockWidth.text.toString()
        val height = binding.blockHeight.text.toString()
        return length.toDouble() * width.toDouble() * height.toDouble()
    }

}