package com.example.pascalandroid.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pascalandroid.databinding.CardViewContactBinding
import com.example.pascalandroid.home.model.ContactModel

class ContactViewHolder(itemView: View, private val listener: ContactListener)
    : RecyclerView.ViewHolder(itemView) {
    val binding = CardViewContactBinding.bind(itemView)

    fun bind(contact: ContactModel) {
        binding.apply {
            contactName.text = contact.name
            contactJob.text = contact.job
            contactImage.setImageResource(contact.contactImage)
            contactDelete.setOnClickListener {
                listener.onDelete(contact)
            }
        }
    }
}