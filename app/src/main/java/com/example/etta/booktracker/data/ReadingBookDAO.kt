package com.example.etta.booktracker.data

import android.arch.persistence.room.*

@Dao
interface ReadingBookDAO {


    @Query("SELECT * FROM readingbook")
    fun findAllItems(): List<ReadingBook> //Return a list of todos

    @Insert
    fun insertItem(item: ReadingBook):Long  //Returns the todoID as Long

    @Delete
    fun deleteItem(item: ReadingBook)

    @Update
    fun updateItem(item:ReadingBook)

    @Query("DELETE FROM readingbook")
    fun deleteAll()

}