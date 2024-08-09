package com.route.islamic40gsat.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.Constants
import com.route.islamic40gsat.Quote
import com.route.islamic40gsat.R
import com.route.islamic40gsat.activities.QuoteDetailsActivity
import com.route.islamic40gsat.adapters.QuotesAdapter
import com.route.islamic40gsat.callbacks.OnQuoteClickListener

class HadethFragment : Fragment() {
    lateinit var hadethListRecyclerView: RecyclerView
    lateinit var adapter: QuotesAdapter
    lateinit var quotesMutableList: MutableList<Quote>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    fun initViews(view: View) {
        hadethListRecyclerView = view.findViewById(R.id.hadeth_list_recycler_view)
        val allFileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        val hadethList = allFileContent.split("#")
        quotesMutableList = mutableListOf()
        hadethList.forEach { hadeth ->
            Log.e("hadeth", "initViews 1:  $hadeth")
            val hadethSeparated = hadeth.trim().split("\n")
            Log.e("hadeth", "initViews 2:  ${hadethSeparated.get(0)}")
            val title = hadethSeparated.get(0)
            val description: String =
                hadethSeparated.subList(1, hadethSeparated.size).joinToString()
            val quote = Quote(title, description)
            quotesMutableList.add(quote)
        }
        val adapter = QuotesAdapter(quotesMutableList)
        hadethListRecyclerView.adapter = adapter
        adapter.onQuoteClickListener = object : OnQuoteClickListener {
            override fun onQuoteClick(quote: Quote, position: Int) {
                val intent = Intent(requireActivity(), QuoteDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_QUOTE_TITLE, quote.title)
                intent.putExtra(Constants.EXTRA_QUOTE_DESC, quote.description)
                startActivity(intent)
            }
        }
    }
}