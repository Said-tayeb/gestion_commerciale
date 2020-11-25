package com.example.safesoftapplication.ui.monPanier

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import com.example.safesoftapplication.databinding.ListItemPanierBinding
import com.squareup.picasso.Picasso

class MonPanierAdapter constructor(val clickListener: PanierListener) : ListAdapter<PanierEntity, MonPanierAdapter.ViewHolder>(MonPaniertDiffCallback()) {

    class MonPaniertDiffCallback : DiffUtil.ItemCallback<PanierEntity>() {
        override fun areItemsTheSame(oldItem: PanierEntity, newItem: PanierEntity): Boolean {
            return oldItem.idPanier == newItem.idPanier
        }

        override fun areContentsTheSame(oldItem: PanierEntity, newItem: PanierEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor( val binding: ListItemPanierBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: PanierEntity,
            clickListener: PanierListener
        ) {
            val res = itemView.context.resources
            binding.panier = item
            binding.imageProduit.setImageResource(R.drawable.ic_checklist)
            binding.clickListener = clickListener
            Picasso
                .get()
                .load(item.imageProduit)
                .placeholder(R.drawable.ic_delivery_box)
                .error(R.drawable.ic_no_item)
                .fit()
                .into(binding.imageProduit)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemPanierBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

/**
 *classe pour gerer les clics
 */
class PanierListener(val clickListener: (idProduit: Int) -> Unit) {
    fun onClick(panierEntity: PanierEntity) = clickListener(panierEntity.idProduit)
}