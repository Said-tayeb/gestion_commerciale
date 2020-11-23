package com.example.safesoftapplication.ui.mesCommandes

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.safesoftapplication.backend.api.bdLocal.entity.CommandeEntity

@BindingAdapter("dateCommande")
fun TextView.setDateCommande(item : CommandeEntity){
    text =  "Date commande" + item.dateCommande

}

@BindingAdapter("dateExpCommande")
fun TextView.setDateExp(item : CommandeEntity){
    text = "Date d'expiration : " + item.dateExpCommande
}

@BindingAdapter("prixCommande")
fun TextView.setPrixCommande(item : CommandeEntity){
    text = "Prix total : " + item.prixTotalCommande.toString() + " Da"
}