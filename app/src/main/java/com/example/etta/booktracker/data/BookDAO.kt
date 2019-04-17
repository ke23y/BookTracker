package com.example.etta.booktracker.data

import android.arch.persistence.room.*

@Dao
interface BookDAO {

    @Query("SELECT * FROM book")
    fun findAllItems(): List<Book> //Return a list of todos

    @Insert
    fun insertItem(item: Book):Long  //Returns the todoID as Long

    @Delete
    fun deleteItem(item: Book)

    @Update
    fun updateItem(item:Book)

    @Query("DELETE FROM book")
    fun deleteAll()
}