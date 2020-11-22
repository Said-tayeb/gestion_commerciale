package com.example.safesoftapplication.ui.catalogue

import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse.produitsResponse
import com.example.safesoftapplication.databinding.FragmentElementCatalogueBinding
import com.example.safesoftapplication.ui.generics.adapter.GenericRecyclerAdapter
import com.example.safesoftapplication.ui.generics.listeners.OnItemClickListener
import com.example.safesoftapplication.ui.viewHolder.BindingViewHolder
import javax.inject.Inject

class CatalogueAdapter @Inject constructor() :
    GenericRecyclerAdapter<produitsResponse, FragmentElementCatalogueBinding>() {

    lateinit var deleter: OnItemClickListener

    init {
        layout = R.layout.fragment_gallery
        items = mutableListOf()
        empty_text = R.string.cataloguevide
    }

    override fun doOnBindViewHolder(
        holder: BindingViewHolder<FragmentElementCatalogueBinding>,
        position: Int
    ) {

    }


}
