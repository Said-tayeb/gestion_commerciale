package com.example.safesoftapplication.ui.monPanier

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.PanierEntity
import com.example.safesoftapplication.databinding.ListItemPanierBinding


class MonPanierAdapter : ListAdapter<PanierEntity, MonPanierAdapter.ViewHolder>(MonPaniertDiffCallback()) {

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
        holder.bind(item)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor( val binding: ListItemPanierBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: PanierEntity
        ) {
            val res = itemView.context.resources
            binding.idPrixProduit.text = item.prixProduit.toString() + "DA"
            binding.imageProduit.setImageResource(R.drawable.ic_checklist)
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