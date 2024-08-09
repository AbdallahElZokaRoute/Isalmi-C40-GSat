package com.route.islamic40gsat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsat.R
import com.route.islamic40gsat.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>?) : Adapter<VersesAdapter.VersesViewHolder>() {

    class VersesViewHolder(
        val itemVerseView: ItemVerseBinding,
    ) : ViewHolder(itemVerseView.root) {
        fun bind(verse: String) {
            itemVerseView.content.text = "$verse(${layoutPosition + 1})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VersesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return verses?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = verses?.get(position)!!
        holder.bind(item)
    }
}