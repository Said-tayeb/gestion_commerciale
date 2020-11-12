package com.example.safesoftapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentHomeBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )

        binding.button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_home_to_nav_gallery)
        }

        binding.button2.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_home_to_nav_mesCommandes)
        }

        binding.button3.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_home_to_nav_monCompte)
        }

        binding.button4.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_home_to_nav_monPanier)
        }

        binding.button5.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_home_to_nav_contacts)
        }
        return binding.root
    }


//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//        })
}