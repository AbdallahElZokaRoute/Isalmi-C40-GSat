package com.route.islamic40gsat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsat.ChapterData
import com.route.islamic40gsat.R
import com.route.islamic40gsat.callbacks.OnChapterClickListener
import com.route.islamic40gsat.databinding.ItemChapterNameBinding

class ChaptersAdapter(val chapters: List<ChapterData>) :
    Adapter<ChaptersAdapter.ChapterViewHolder>() {
    var onChapterClickListener: OnChapterClickListener? = null

    class ChapterViewHolder(
        private val binding: ItemChapterNameBinding,
        private val onChapterClickListener: OnChapterClickListener? = null
    ) :
        ViewHolder(binding.root) {
        fun bind(item: ChapterData, position: Int) {
            binding.chapterName.text = item.name
            binding.chapterPosition.text = "${item.position}"
            binding.root.setOnClickListener {
                onChapterClickListener?.onChapterClick(item, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChapterNameBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding, onChapterClickListener)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = chapters[position]
        holder.bind(item, position)
    }
}
