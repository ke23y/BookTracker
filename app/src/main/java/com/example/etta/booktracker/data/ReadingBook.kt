package com.example.etta.booktracker.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "readingbook")
data class ReadingBook(
    @PrimaryKey(autoGenerate = true) var itemID: Long?,  //autogenerate must be true.
    @ColumnInfo(name = "name") var bookName: String, //title of the book
    @ColumnInfo(name = "author") var author: String, //title of the book
    @ColumnInfo(name = "done") var done: Boolean?,
    @ColumnInfo(name = "language") var language: String?,
    @ColumnInfo(name = "desire") var desire: Int,
    @ColumnInfo(name = "subject") var subject: String?,
    @ColumnInfo(name = "ISBN-13") var isbn:String?,
    @ColumnInfo(name = "page") var currentPage:String?
) : Serializable //we need this for