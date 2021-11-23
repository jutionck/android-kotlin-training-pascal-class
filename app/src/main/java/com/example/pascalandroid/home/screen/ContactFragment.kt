package com.example.pascalandroid.home.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pascalandroid.databinding.FragmentContactBinding
import com.example.pascalandroid.home.adapter.ContactAdapter

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var cAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(requireContext())
        cAdapter = ContactAdapter()
        binding.apply {
            contactRecyclerView.layoutManager = layoutManager
            contactRecyclerView.adapter = cAdapter
        }
    }
}