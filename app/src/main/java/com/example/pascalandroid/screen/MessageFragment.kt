package com.example.pascalandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pascalandroid.R
import com.example.pascalandroid.activity.HomeActivity
import com.example.pascalandroid.communicator.MessageCommunicator
import com.example.pascalandroid.databinding.FragmentGreetingBinding
import com.example.pascalandroid.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.btnSign.setOnClickListener {
           sendMessage()
        }
    }

    private fun sendMessage() {
//        val bundle = bundleOf(HomeActivity.MESSAGE to binding.teFullName.text.toString())
//        navController.navigate(R.id.action_global_homeFragment, bundle)
        navController.navigate(MessageFragmentDirections.actionMessageFragmentToHomeFragment(binding.teFullName.text.toString()))

    }
}