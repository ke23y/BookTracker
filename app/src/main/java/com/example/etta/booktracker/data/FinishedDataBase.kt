package com.example.etta.booktracker.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(FinishedBook::class), version = 1)
abstract class FinishedDataBase : RoomDatabase() {

    abstract fun finishedBookDAO(): FinishedBookDAO

    companion object {
        private var INSTANCE: FinishedDataBase? = null

        fun getInstance(context: Context): FinishedDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    FinishedDataBase::class.java, "finishedbooks.db")
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}