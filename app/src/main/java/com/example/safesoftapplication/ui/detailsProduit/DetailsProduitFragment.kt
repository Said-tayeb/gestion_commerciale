package com.example.safesoftapplication.ui.detailsProduit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentDetailsProduitBinding
import com.example.safesoftapplication.databinding.FragmentInscriptionBinding
import com.example.safesoftapplication.vM.DetailsProduitVM
import com.example.safesoftapplication.vM.catalogueVM.CatalogueVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsProduitFragment : Fragment() {
    private  val viewModel: DetailsProduitVM by viewModels()

    private lateinit var binding: FragmentDetailsProduitBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentDetailsProduitBinding>(inflater,
            R.layout.fragment_details_produit,container,false)

        var idProduit = 1


        viewModel.getProduit(idProduit)


        return binding.root





    }
}