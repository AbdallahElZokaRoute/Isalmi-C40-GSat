package com.route.islamic40gsat.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsat.ChapterData
import com.route.islamic40gsat.ChapterDetailsActivity
import com.route.islamic40gsat.Constants
import com.route.islamic40gsat.R
import com.route.islamic40gsat.adapters.ChaptersAdapter
import com.route.islamic40gsat.callbacks.OnChapterClickListener
import com.route.islamic40gsat.databinding.FragmentQuranBinding

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var adapter: ChaptersAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews() {
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
        binding.chaptersRecyclerView.adapter = adapter
        Log.e("TAG", "initViews: ${AppCompatDelegate.getDefaultNightMode()}")
        if (isLight())
            binding.switchModeButton.text = "Dark Mode"
        else
            binding.switchModeButton.text = "Light Mode"

        binding.switchModeButton.setOnClickListener {
            if (isLight()) {
                Log.e("TAG", "initViews: inside OnClick Listener Should Be Dark")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                Log.e("TAG", "initViews: inside OnClick Listener Should Be Light ")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    fun isLight(): Boolean {
        Log.e("TAG", "isLight: ${AppCompatDelegate.getDefaultNightMode()}")
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO ||
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }
}