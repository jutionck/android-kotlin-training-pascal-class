package com.example.pascalandroid.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pascalandroid.R
import com.example.pascalandroid.databinding.CardViewContactBinding
import com.example.pascalandroid.home.model.ContactModel

class ContactAdapter(val listener: ContactListener)
    : RecyclerView.Adapter<ContactViewHolder>() {

    var contactsList = ArrayList<ContactModel>()
    // Hasil implement dari RecyclerView.Adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // Kita inject view yang sudah dibuat card_view_contact.xml di dalam sini
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_contact, parent, false)
        return ContactViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.bind(contact)
    }

    override fun getItemCount() = contactsList.size

    fun setContact(newContact: List<ContactModel>) {
        contactsList.clear()
        contactsList.addAll(newContact)
        notifyDataSetChanged()
    }
}