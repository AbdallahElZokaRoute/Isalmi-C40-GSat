package com.route.islamic40gsat.callbacks

import com.route.islamic40gsat.ChapterData

interface OnChapterClickListener {
    fun onChapterClick(chapter: ChapterData, chapterPosition: Int)
}