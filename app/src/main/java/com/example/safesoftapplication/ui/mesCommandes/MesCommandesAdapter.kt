package com.example.safesoftapplication.ui.mesCommandes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity
import com.example.safesoftapplication.databinding.ListItemCommandesBinding

class MesCommandesAdapter(val clickListener: CommandeListener)
    : ListAdapter<CommandeEntity, MesCommandesAdapter.ViewHolder>(MesCommandesDiffCallback()) {

    /**
     * classe de mis à jour de recycler view
     */
    class MesCommandesDiffCallback : DiffUtil.ItemCallback<CommandeEntity>() {
        override fun areItemsTheSame(oldItem: CommandeEntity, newItem: CommandeEntity): Boolean {
            return oldItem.idCommande == newItem.idCommande
        }

        override fun areContentsTheSame(oldItem: CommandeEntity, newItem: CommandeEntity): Boolean {
            return oldItem == newItem
        }
    }

    /**
     * afficher les donnees d'un element d'une liste a la position specifier
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //le item de la position
        val item = getItem(position)!!
        holder.bind(getItem(position)!!, clickListener)
    }

    /**
     * une fonction qui vas être appelé lorsque le RecyclerView a besoin d'un détenteur de vue pour représenter un élément
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemCommandesBinding) : RecyclerView.ViewHolder(binding.root){

        companion object {

            /**
             * afficher les donnees d'un element d'une liste a la position specifier
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemCommandesBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        /**
         * definition des donnees
         */
        fun bind(
            item: CommandeEntity,
            clickListener: CommandeListener
        ) {
            //une référence à la resourcespour cette vue
            val res = itemView.context.resources
            binding.commande = item
            binding.clickListener = clickListener
            //deffinition des donnees
            binding.executePendingBindings()
        }
    }
}

/**
 *classe pour gerer les clics
 */
class CommandeListener(val clickListener: (idCommande: Int) -> Unit) {
    fun onClick(commandeEntity: CommandeEntity) = clickListener(commandeEntity.idCommande)
}