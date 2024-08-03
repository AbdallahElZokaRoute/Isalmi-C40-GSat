package com.route.islamic40gsat.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.Constants
import com.route.islamic40gsat.R
import com.route.islamic40gsat.adapters.VersesAdapter

class QuoteDetailsActivity : AppCompatActivity() {
    var title: String? = ""
    var description: String? = ""
    lateinit var quoteDetailsRecyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView
    lateinit var backImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)
        initParams()
        initViews()
    }

    private fun initViews() {
        // 1- TextView -> ScrollView     -> 1000
        // 2- RecyclerView    // Lazily
        quoteDetailsRecyclerView = findViewById(R.id.quote_description_recycler_view)
        adapter = VersesAdapter(description?.split("\n"))
        quoteDetailsRecyclerView.adapter = adapter
        backImage = findViewById(R.id.icon_back)
        backImage.setOnClickListener {
            finish()
        }
        titleTextView = findViewById(R.id.toolbar_title)
        titleTextView.text = title
    }

    private fun initParams() {
        title = intent.getStringExtra(Constants.EXTRA_QUOTE_TITLE)
        description = intent.getStringExtra(Constants.EXTRA_QUOTE_DESC)
    }
}