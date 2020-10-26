package com.example.safesoftapplication.ui.CatalogueClient

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.safesoftapplication.model.Produit

class listeCatalogueAdapteur : BaseAdapter() {

    lateinit var lesProduits : ArrayList<Produit>
    /**
     * retourner le nombre de ligne
     */
    override fun getCount(): Int {
        TODO("Not yet implemented")
        lesProduits.size
    }

    /**
     * retourner l'item de la ligne actuelle
     */
    override fun getItem(i: Int): Any {
        TODO("Not yet implemented")
        return lesProduits.get(i)
    }

    /**
     * retourner un indice par rapport a la ligne actuelle
     */
    override fun getItemId(i: Int): Long {
        TODO("Not yet implemented")
        return (i.toLong())
    }

    /**
     * retourne la ligne (view) formaté avec gestion des évenements
     */
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}