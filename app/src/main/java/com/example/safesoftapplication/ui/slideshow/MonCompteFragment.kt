package com.example.safesoftapplication.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.databinding.FragmentSlideshowBinding
import dagger.hilt.android.AndroidEntryPoint

//import com.example.safesoftapplication.ViewModel.MonCompteViewModel

@AndroidEntryPoint
class MonCompteFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentSlideshowBinding>(inflater,
            R.layout.fragment_slideshow,container,false)

        return binding.root

    }
}