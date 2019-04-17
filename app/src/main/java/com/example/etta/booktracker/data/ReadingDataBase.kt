package com.example.etta.booktracker.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(ReadingBook::class), version = 1)
abstract class ReadingDataBase : RoomDatabase() {

    abstract fun readingBookDAO(): ReadingBookDAO

    companion object {
        private var INSTANCE: ReadingDataBase? = null

        fun getInstance(context: Context): ReadingDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ReadingDataBase::class.java, "readingbooks.db")
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}