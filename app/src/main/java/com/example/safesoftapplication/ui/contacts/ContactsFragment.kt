package com.example.safesoftapplication.ui.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentContactsBinding
import com.example.safesoftapplication.databinding.FragmentDetailsAchatBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentContactsBinding>(inflater,
            R.layout.fragment_contacts,container,false)

        return binding.root

    }

}