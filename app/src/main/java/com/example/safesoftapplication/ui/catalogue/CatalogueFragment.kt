package com.example.safesoftapplication.ui.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.safesoftapplication.R
import com.example.safesoftapplication.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogueFragment : Fragment() {

    private lateinit var catalogueViewModel: CatalogueViewModel
    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentGalleryBinding>(inflater,
            R.layout.fragment_gallery,container,false)

        binding.button6.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_catalogueFragment_to_detailsProduitFragment)
        }
        return binding.root
    }

//    galleryViewModel =
//            ViewModelProvider(this).get(GalleryViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
//        val textView: TextView = root.findViewById(R.id.text_gallery)
//        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
}