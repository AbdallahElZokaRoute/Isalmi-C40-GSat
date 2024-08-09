package com.route.islamic40gsat

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.adapters.VersesAdapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var chapterName: String
    var chapterPosition: Int = -1
    lateinit var adapter: VersesAdapter
    lateinit var versesRecyclerView: RecyclerView
    lateinit var titleTextView: TextView
    lateinit var backImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_details)
        initParams()
        initViews()
        readChapterFromFile()
    }

    fun initParams() {
        chapterName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME) ?: ""
        chapterPosition = intent.getIntExtra(Constants.EXTRA_CHAPTER_POSITION, -1)
    }

    fun initViews() {
        versesRecyclerView = findViewById(R.id.verses_recycler_view)
        titleTextView = findViewById(R.id.title_toolbar)
        titleTextView.text = chapterName
        backImageView = findViewById(R.id.icon_back)
        backImageView.setOnClickListener {
            finish()
        }
    }

    fun readChapterFromFile() {
        val allFileContent = assets.open("$chapterPosition.txt")
            .bufferedReader()
            .readText()
        val verses = allFileContent.trim().split("\n")
        adapter = VersesAdapter(verses)
        versesRecyclerView.adapter = adapter
    }
}

// Persistant Data Storage
//
val query = "SELET * FROM CUSTOMERS"

// SQL Query

