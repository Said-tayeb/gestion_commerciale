package com.example.safesoftapplication.ui.viewHolder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.safesoftapplication.ui.generics.listeners.OnItemClickListener
import com.example.safesoftapplication.ui.generics.listeners.OnItemLongClickListener

class BindingViewHolder<T : ViewDataBinding>(item: View) :
    RecyclerView.ViewHolder(item) {
    var binding: T? = DataBindingUtil.bind(item)


    fun setClickListeners(
        position: Int,
        normalClickListener: OnItemClickListener?,
        longClick: OnItemLongClickListener?
    ) {
        if (normalClickListener != null) itemView.setOnClickListener { v: View? ->
            normalClickListener.onItemSelected(
                position,
                v
            )
        }
        if (longClick != null) itemView.setOnLongClickListener { v: View? ->
            longClick.onItemSelected(
                position,
                v
            )
        }
    }

}