package com.example.safesoftapplication.ui.recherche

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.databinding.FragmentRechercheBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RechercheFragment : Fragment() {

    private lateinit var binding: FragmentRechercheBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentRechercheBinding>(inflater,
            R.layout.fragment_recherche,container,false)

        return binding.root

    }


}