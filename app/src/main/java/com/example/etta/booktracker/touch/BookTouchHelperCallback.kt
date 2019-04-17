package com.example.etta.booktracker.touch

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class BookTouchHelperCallback (private val bookTouchHelperAdapter: BookTouchHelperAdapter):
    ItemTouchHelper.Callback() {


        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }

        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
            return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
        }

        override fun onMove(recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            bookTouchHelperAdapter.onItemMoved(
                viewHolder.adapterPosition,
                target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            bookTouchHelperAdapter.onDismissed(viewHolder.adapterPosition)
        }


    }