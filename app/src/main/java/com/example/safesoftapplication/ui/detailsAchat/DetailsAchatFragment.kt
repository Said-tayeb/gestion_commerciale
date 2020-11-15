package com.example.safesoftapplication.ui.detailsAchat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentDetailsAchatBinding
import com.example.safesoftapplication.databinding.FragmentDetailsProduitBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsAchatFragment : Fragment() {

    private lateinit var binding: FragmentDetailsAchatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentDetailsAchatBinding>(inflater,
            R.layout.fragment_details_achat,container,false)

        return binding.root

    }
}