package com.example.safesoftapplication.ui.mesCommandes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.databinding.FragmentMesCommandesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MesCommandesFragment : Fragment() {

    private lateinit var binding: FragmentMesCommandesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMesCommandesBinding>(inflater,
            R.layout.fragment_mes_commandes,container,false)

        binding.button7.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_mesCommandes_to_detailsAchatFragment)
        }

        return binding.root
    }
}