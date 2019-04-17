package com.example.etta.booktracker.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
import java.util.*

//We say that this calss is a data calss here, and we name the table todo.
@Entity (tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true) var itemID: Long?,  //autogenerate must be true.
    @ColumnInfo(name = "name") var bookName: String, //title of the book
    @ColumnInfo(name = "author") var author: String, //title of the book
    @ColumnInfo(name = "done") var done: Boolean?,
    @ColumnInfo(name = "language") var language: String?,
    @ColumnInfo(name = "desire") var desire: Int,
    @ColumnInfo(name = "subject") var subject: String?,
    @ColumnInfo(name = "ISBN-13") var isbn:String?,
    @ColumnInfo(name = "startdate") var startDate:String?,
    @ColumnInfo(name = "finishDate") var finishDate:String?,
    @ColumnInfo(name = "page") var currentPage:String?


) :Serializable //we need this for