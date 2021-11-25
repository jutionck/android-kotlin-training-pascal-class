package com.example.pascalandroid.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pascalandroid.R
import com.example.pascalandroid.home.adapter.ContactListener
import com.example.pascalandroid.home.model.ContactModel

class ContactViewModel : ViewModel(), ContactListener {

    private var _contactLiveData = MutableLiveData<List<ContactModel>>()
    val contactLiveData: LiveData<List<ContactModel>> get() = _contactLiveData

    // Contact Dummy
    private var contacts = arrayListOf(
        ContactModel("JUTION CANDRA KIRANA", "Android Developer", R.drawable.ic_account_circle),)

    init {
        loadDataContact()
    }

    private fun loadDataContact() {
        _contactLiveData.value = contacts
    }

    fun addContact(contact: ContactModel) {
        contacts.add(contact)
        _contactLiveData.value = contacts
    }

    override fun onDelete(contact: ContactModel) {
        val contactIndex = contacts.indexOf(contact)
        contacts.removeAt(contactIndex)
        _contactLiveData.value = contacts
    }
}