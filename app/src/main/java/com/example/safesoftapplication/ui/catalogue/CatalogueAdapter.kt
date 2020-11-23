package com.example.safesoftapplication.ui.catalogue

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.ProduitEntity
import com.example.safesoftapplication.databinding.FragmentElementCatalogueBinding
import com.squareup.picasso.Picasso
import java.io.File

class CatalogueAdapter  : ListAdapter<ProduitEntity, CatalogueAdapter.ViewHolder>(CataloguetDiffCallback()) {

    class CataloguetDiffCallback : DiffUtil.ItemCallback<ProduitEntity>() {
        override fun areItemsTheSame(oldItem: ProduitEntity, newItem: ProduitEntity): Boolean {
            return oldItem.idProduit == newItem.idProduit
        }

        override fun areContentsTheSame(oldItem: ProduitEntity, newItem: ProduitEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor( val binding: FragmentElementCatalogueBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: ProduitEntity
        ) {
            val res = itemView.context.resources
            binding.idPrixProduit.text = item.prixProduit.toString() + " DA"
            Picasso
                .get()
                .load(item.imageProduit)
//                .placeholder(R.drawable.ic_delivery_box)
                .error(R.drawable.ic_no_item)
                .fit()
                .into(binding.imageProduit)

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    FragmentElementCatalogueBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}