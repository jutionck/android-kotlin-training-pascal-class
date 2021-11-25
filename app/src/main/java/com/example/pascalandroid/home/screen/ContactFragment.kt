package com.example.pascalandroid.home.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.FragmentContactBinding
import com.example.pascalandroid.home.adapter.ContactAdapter
import com.example.pascalandroid.home.model.ContactModel
import com.example.pascalandroid.home.viewmodel.ContactViewModel

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    private lateinit var contactViewModel: ContactViewModel
    private lateinit var cAdapter: ContactAdapter

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
        initViewModel()
        binding.apply {
            cAdapter = ContactAdapter(contactViewModel)
            addContact.setOnClickListener {
                findNavController().navigate(R.id.action_contactFragment_to_formContactFragment)
            }
            contactRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cAdapter
            }
        }
        subscribe()
    }

    private fun initViewModel() {
        contactViewModel = ViewModelProvider(requireActivity())[ContactViewModel::class.java]
    }

    private fun subscribe() {
        contactViewModel.contactLiveData.observe(viewLifecycleOwner, {
            cAdapter.setContact(it)
        })
    }
}