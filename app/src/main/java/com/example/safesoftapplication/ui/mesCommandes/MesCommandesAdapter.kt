package com.example.safesoftapplication.ui.mesCommandes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.R
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

class MesCommandesAdapter : RecyclerView.Adapter<MesCommandesAdapter.ViewHolder>() {

    var data =  listOf<CommandeEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * renvoyer la longueur de la liste au recyclerView
     */
    override fun getItemCount() = data.size

    /**
     * afficher les donnees d'un element d'une liste a la position specifier
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //le item de la position
        val item = data[position]
        holder.bind(item)
    }

    /**
     * une fonction qui vas être appelé lorsque le RecyclerView a besoin d'un détenteur de vue pour représenter un élément
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val dateCommande: TextView = itemView.findViewById(R.id.textViewdatCommande)
        val datExpCommande: TextView = itemView.findViewById(R.id.textViewDateExp)
        val prixCommande: TextView = itemView.findViewById(R.id.textViewPrixCommande)

        companion object {

            /**
             * afficher les donnees d'un element d'une liste a la position specifier
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_commandes, parent, false)

                return ViewHolder(view)
            }
        }

        /**
         * definition des donnees
         */
        fun bind(
            item: CommandeEntity
        ) {
            //une référence à la resourcespour cette vue
            val res = itemView.context.resources

            //deffinition des donnees
            dateCommande.text = "Date de la commande : " + item.dateCommande.toString()
            datExpCommande.text = "Date d'experation : " + item.dateExpCommande.toString()
            prixCommande.text = "Prix Total : " + item.prixTotalCommande.toString() + " Da"
        }
    }

}