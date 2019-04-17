package com.example.etta.booktracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.etta.booktracker.FinishedActivity
import com.example.etta.booktracker.R
import com.example.etta.booktracker.ReadingActivity
import com.example.etta.booktracker.data.*
import com.example.etta.booktracker.touch.BookTouchHelperAdapter
import kotlinx.android.synthetic.main.row_finished.view.*
import java.util.*

class FinishedAdapter : RecyclerView.Adapter<FinishedAdapter.ViewHolder>, BookTouchHelperAdapter {


    var books = mutableListOf<FinishedBook>()


    val context: Context

    //Constructor which can receive two arguments
    constructor(context: Context, items: List<FinishedBook>) : super() {
        this.context = context
        this.books.addAll(items) //Copy all items from the list
    }

    constructor(context: Context) : super() {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.row_finished, parent, false
        )
        return ViewHolder(view)
    }

    @Override
    override fun getItemCount(): Int {
        return books.size
    }

    @Override
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]

        //Show the spinnner


        when {
            book.desire == 0 -> holder.tvImage_finished.setImageResource(R.drawable.star1)
            book.desire == 1 -> holder.tvImage_finished.setImageResource(R.drawable.star2)
            book.desire == 2 -> holder.tvImage_finished.setImageResource(R.drawable.star3)
            book.desire == 3 -> holder.tvImage_finished.setImageResource(R.drawable.star4)
            book.desire == 4 -> holder.tvImage_finished.setImageResource(R.drawable.star5)
        }

        holder.tvName_finished.text = book.bookName
        holder.tvAuthor_finished.text = book.author

        holder.btnDelete_finished.setOnClickListener {
            deleteItem(holder.adapterPosition)
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Slide to Delete", Toast.LENGTH_LONG).show()
        }


        setUpDialogFInished(holder, book)

    }

    private fun setUpDialogFInished(
        holder: ViewHolder,
        book: FinishedBook
    ) {
        holder.tvName_finished.setOnClickListener {
            (context as FinishedActivity).showFinishedDialog(
                book, holder.adapterPosition
            )
        }

        holder.tvAuthor_finished.setOnClickListener {
            (context as FinishedActivity).showFinishedDialog(
                book, holder.adapterPosition
            )
        }

        holder.tvImage_finished.setOnClickListener {
            (context as FinishedActivity).showFinishedDialog(
                book, holder.adapterPosition
            )
        }
    }


    //Changed this method to make sure that when we delete an item, we also delete it from the database
    private fun deleteItem(adapterPosition: Int) {

        //Remove the todo item from the data base
        Thread {
            FinishedDataBase.getInstance(context).finishedBookDAO().deleteItem(books[adapterPosition])

            //Remove the item from the recycler view. This line must be put in the tread because this line could be
            //excuted earlier. If yes, there is nothing to remove from data base and we'll get a outofbound error
            books.removeAt(adapterPosition)

            (context as FinishedActivity).runOnUiThread {
                notifyItemRemoved(adapterPosition)
            }

        }.start()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        //For to read list

        //For reading list
        val tvName_finished = itemView.tvName_finished
        val btnDelete_finished = itemView.btnDelete_finished
        val tvAuthor_finished = itemView.tvAuthor_finished
        val tvImage_finished = itemView.tvImage_finished

    }

    fun addItem(item: FinishedBook) {
        books.add(0, item)
        //notifyDataSetChanged()
        notifyItemInserted(0)
    }


    fun deleteAll(){
        books.clear()
        notifyDataSetChanged()
    }

    override fun onDismissed(position: Int) {
        deleteItem(position)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(books, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    //update the todolist
    fun updateToBuy(item: FinishedBook, idx: Int) {
        books[idx] = item
        notifyItemChanged(idx) //Update the dialog
    }

}