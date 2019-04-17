package com.example.etta.booktracker.data

import android.arch.persistence.room.*

@Dao
interface FinishedBookDAO {


    @Query("SELECT * FROM finishedbook")
    fun findAllItems(): List<FinishedBook> //Return a list of todos

    @Insert
    fun insertItem(item: FinishedBook):Long  //Returns the todoID as Long

    @Delete
    fun deleteItem(item: FinishedBook)

    @Update
    fun updateItem(item:FinishedBook)

    @Query("DELETE FROM finishedbook")
    fun deleteAll()

}