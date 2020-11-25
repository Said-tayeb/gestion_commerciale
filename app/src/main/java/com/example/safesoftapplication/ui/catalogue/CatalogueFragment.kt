package com.example.safesoftapplication.ui.catalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentGalleryBinding
import com.example.safesoftapplication.vM.catalogueVM.CatalogueVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogueFragment : Fragment() {

    private  val viewModel: CatalogueVM by viewModels()
    private lateinit var binding: FragmentGalleryBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate<FragmentGalleryBinding>(
            inflater,
            R.layout.fragment_gallery, container, false
        )


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = CatalogueAdapter(ProduitListener { idProduit ->
            viewModel.clicProduit(idProduit)
            viewModel.navigateToDetailsProduit.observe(viewLifecycleOwner, Observer {
                it?.let {
                    this.findNavController().navigate(
                        CatalogueFragmentDirections
                            .actionCatalogueFragmentToDetailsProduitFragment(it))
                    viewModel.ProduitDetailsNavgated()
                }
            })
        })
        binding.idRcyclerViewCatlogue.adapter = adapter

        viewModel.recupProduit().observe(viewLifecycleOwner, Observer {
            if (it == null){
                viewModel.getProduit()
            }
            viewModel.getAllProduits().observe(viewLifecycleOwner, Observer {
                Log.d("TAAAAAAAAAG","uccess ${it.data}")
                if (it.data?.isNotEmpty() == true) {
                    Log.d("donnes", "OUI OUI OUI ")
                    adapter.submitList(it.data)
                }
            })
        })

        val manager = GridLayoutManager(activity, 2)
        binding.idRcyclerViewCatlogue.layoutManager = manager

    }
}