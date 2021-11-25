package com.example.pascalandroid.home.adapter

import com.example.pascalandroid.home.model.ContactModel

interface ContactListener {
    fun onDelete(contact: ContactModel)
}