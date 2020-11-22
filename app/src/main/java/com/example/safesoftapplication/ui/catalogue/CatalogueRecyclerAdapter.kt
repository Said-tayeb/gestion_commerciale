package com.example.safesoftapplication.ui.catalogue

import androidx.recyclerview.widget.DiffUtil
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.api.reponses.catalogueResponse.produitsResponse
import com.example.safesoftapplication.databinding.FragmentElementCatalogueBinding
import com.example.safesoftapplication.ui.generics.adapter.GenericPagedListAdapter
import com.example.safesoftapplication.ui.viewHolder.BindingViewHolder
import javax.inject.Inject

class CatalogueRecyclerAdapter @Inject constructor() :
    GenericPagedListAdapter<produitsResponse, FragmentElementCatalogueBinding>(DIFF_CALLBACK) {

    override var layout = R.layout.fragment_element_catalogue
    override var holderText = R.string.cataloguevide

    override fun onBindViewHolder(
        holder: BindingViewHolder<FragmentElementCatalogueBinding>,
        position: Int
    ) {
//        if (getItemViewType(position) != emptyView)
//            holder.binding?.produit = getItem(position)
        super.onBindViewHolder(holder, position)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<produitsResponse>() {
            override fun areItemsTheSame(oldItem: produitsResponse, newItem: produitsResponse) =
                oldItem.idProduit == newItem.idProduit

            override fun areContentsTheSame(oldItem: produitsResponse, newItem: produitsResponse) =
                oldItem == newItem

        }
    }

}
