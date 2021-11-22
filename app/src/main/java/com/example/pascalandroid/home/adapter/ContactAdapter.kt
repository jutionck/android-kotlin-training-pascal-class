package com.example.pascalandroid.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pascalandroid.R

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var contactName = arrayOf(
        "JUTION CANDRA KIRANA",
        "JOAN MAUPAUL",
        "THOMAS MATINI",
        "SISCA HOLD",
        "SARAS NURDIN",
        "ANTONIO CONTE"
    )

    private var contactJob = arrayOf(
        "Android Developer",
        "Backend Developer",
        "Frontend Developer",
        "QA Engineer",
        "Android Developer",
        "Android Developer"
    )

    private var contactImage = intArrayOf(
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.itemContactName.text = contactName[position]
        holder.itemContactJob.text = contactJob[position]
        holder.itemContactImage.setImageResource(contactImage[position])
    }

    override fun getItemCount(): Int = contactName.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemContactImage: ImageView = itemView.findViewById(R.id.contact_image)
        var itemContactName: TextView = itemView.findViewById(R.id.tv_contact_name)
        var itemContactJob: TextView = itemView.findViewById(R.id.tv_contact_job)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on ${contactName[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}