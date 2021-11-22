package com.example.pascalandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment() {

    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!
    private lateinit var fragmentMessage: MessageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentGreetingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMessage = MessageFragment()
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_messageFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    private fun switchFragment(fragment: Fragment) {
//        requireActivity()
//            .supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .setReorderingAllowed(true)
//            .addToBackStack("welcome")
//            .commit()
//    }

}