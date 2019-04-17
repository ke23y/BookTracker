package com.example.etta.booktracker.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.etta.booktracker.R
import com.example.etta.booktracker.ToReadActivity
import com.example.etta.booktracker.data.AppDatabase
import com.example.etta.booktracker.data.Book
import com.example.etta.booktracker.touch.BookTouchHelperAdapter
import kotlinx.android.synthetic.main.row_reading.view.*
import kotlinx.android.synthetic.main.row_to_read.view.*
import java.util.*

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>, BookTouchHelperAdapter {


    var books = mutableListOf<Book>()


    val context: Context

    //Constructor which can receive two arguments
    constructor(context: Context, items: List<Book>) : super() {
        this.context = context
        this.books.addAll(items) //Copy all items from the list
    }

    constructor(context: Context) : super() {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.row_to_read, parent, false
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
            book.desire == 0 -> holder.tvImage.setImageResource(R.drawable.star1)
            book.desire == 1 -> holder.tvImage.setImageResource(R.drawable.star2)
            book.desire == 2 -> holder.tvImage.setImageResource(R.drawable.star3)
            book.desire == 3 -> holder.tvImage.setImageResource(R.drawable.star4)
            book.desire == 4 -> holder.tvImage.setImageResource(R.drawable.star5)
        }

        holder.tvName.text = book.bookName
        holder.tvAuthor.text = book.author

        holder.btnDelete.setOnClickListener {
            deleteItem(holder.adapterPosition)
        }

        setUpDialogue(holder, book)

    }

    private fun setUpDialogue(
        holder: ViewHolder,
        book: Book
    ) {
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Slide to Delete", Toast.LENGTH_LONG).show()
        }


        holder.tvName.setOnClickListener {
            (context as ToReadActivity).showEditItemDialog(
                book, holder.adapterPosition
            )
        }

        holder.tvImage.setOnClickListener {
            (context as ToReadActivity).showEditItemDialog(
                book, holder.adapterPosition
            )
        }

        holder.tvAuthor.setOnClickListener {
            (context as ToReadActivity).showEditItemDialog(
                book, holder.adapterPosition
            )
        }
    }


    //Changed this method to make sure that when we delete an item, we also delete it from the database
    private fun deleteItem(adapterPosition: Int) {

        //Remove the todo item from the data base
        Thread {
            AppDatabase.getInstance(context).bookDAO().deleteItem(books[adapterPosition])

            //Remove the item from the recycler view. This line must be put in the tread because this line could be
            //excuted earlier. If yes, there is nothing to remove from data base and we'll get a outofbound error
            books.removeAt(adapterPosition)

            (context as ToReadActivity).runOnUiThread {
                notifyItemRemoved(adapterPosition)
            }

        }.start()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        //For to read list
        val tvName = itemView.tvName
        //val cbDone = itemView.cbDone
        val btnDelete = itemView.btnDelete
        val tvAuthor = itemView.tvAuthor
        val tvImage = itemView.tvImage

    }

    fun addItem(item: Book) {
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
    fun updateToBuy(item: Book, idx: Int) {
        books[idx] = item
        notifyItemChanged(idx) //Update the dialog
    }

}