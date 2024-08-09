package com.route.islamic40gsat.callbacks

import com.route.islamic40gsat.Quote

// interface callback
// 1-
interface OnQuoteClickListener {
    fun onQuoteClick(quote: Quote, position: Int)
}