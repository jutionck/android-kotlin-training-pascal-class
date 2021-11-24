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

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contactsList = ArrayList<ContactModel>()
    // Hasil implement dari RecyclerView.Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        // Kita inject view yang sudah dibuat card_view_contact.xml di dalam sini
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.itemContactName.text = contactsList[position].name
        holder.itemContactJob.text = contactsList[position].job
        holder.itemContactImage.setImageResource(contactsList[position].contactImage)
    }

    override fun getItemCount() = contactsList.size

    // Ini class buatan untuk ViewHolder
    // Ini dapat di pisahkan beda file jika mau
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = CardViewContactBinding.bind(itemView)
        var itemContactName: TextView = binding.contactName
        var itemContactJob: TextView = binding.contactJob
        var itemContactImage: ImageView = binding.contactImage

        init {
            binding.apply {
                contactDelete.setOnClickListener {
                    val position: Int = adapterPosition
                    Toast
                        .makeText(
                            itemView.context,
                            contactsList[position].name,
                            Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    fun setContact(newContact: List<ContactModel>) {
        contactsList.clear()
        contactsList.addAll(newContact)
        notifyDataSetChanged()
    }
}