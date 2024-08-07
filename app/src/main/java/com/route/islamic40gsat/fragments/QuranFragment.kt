package com.route.islamic40gsat.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.ChapterData
import com.route.islamic40gsat.ChapterDetailsActivity
import com.route.islamic40gsat.Constants
import com.route.islamic40gsat.R
import com.route.islamic40gsat.adapters.ChaptersAdapter
import com.route.islamic40gsat.callbacks.OnChapterClickListener

class QuranFragment : Fragment() {
    lateinit var chaptersRecyclerView: RecyclerView
    lateinit var adapter: ChaptersAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    fun initViews(view: View) {
        chaptersRecyclerView = view.findViewById(R.id.chapters_recycler_view)
        val chapters = Constants.chapters
        val chaptersDataList = mutableListOf<ChapterData>()
        chapters.forEachIndexed { index, name ->
            chaptersDataList.add(ChapterData(name, index + 1))
        }
        adapter = ChaptersAdapter(chaptersDataList)
        adapter.onChapterClickListener = object : OnChapterClickListener {
            override fun onChapterClick(chapter: ChapterData, chapterPosition: Int) {
                // context?  or requireContext
                // activity or requireActivity
                val intent = Intent(requireContext(), ChapterDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_CHAPTER_NAME, chapter.name)
                intent.putExtra(Constants.EXTRA_CHAPTER_POSITION, chapter.position)
                startActivity(intent)
            }
        }
        chaptersRecyclerView.adapter = adapter

    }
}