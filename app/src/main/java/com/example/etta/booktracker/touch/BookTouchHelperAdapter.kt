package com.example.etta.booktracker.touch

interface BookTouchHelperAdapter {
    fun onDismissed(position: Int)
    fun onItemMoved(fromPosition: Int, toPosition: Int)
}