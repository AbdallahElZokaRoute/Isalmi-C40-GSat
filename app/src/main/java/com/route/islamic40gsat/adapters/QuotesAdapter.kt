package com.route.islamic40gsat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsat.Quote
import com.route.islamic40gsat.R
import com.route.islamic40gsat.callbacks.OnQuoteClickListener

class QuotesAdapter(val quotesList: List<Quote>) : Adapter<QuotesAdapter.QuotesViewHolder>() {
    // 2-
    var onQuoteClickListener: OnQuoteClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_verse, parent, false)
        return QuotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = quotesList.get(position)
        holder.quote.text = item.title
        // 3-
        holder.quote.setOnClickListener {
            onQuoteClickListener?.onQuoteClick(item, position)
        }
    }

    class QuotesViewHolder(private val itemQuoteView: View) : ViewHolder(itemQuoteView) {
        val quote: TextView = itemQuoteView.findViewById(R.id.content)
    }


}