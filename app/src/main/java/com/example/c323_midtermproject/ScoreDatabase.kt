package com.example.c323_midtermproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class ScoreDatabase : RoomDatabase() {
    // initialize scoreDao
    abstract val scoreDao: ScoreDao
    companion object {
        @Volatile
        private var INSTANCE: ScoreDatabase? = null

        /**
         * get specific instance from NoteDatabase
         */
        fun getInstance(context: Context): ScoreDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScoreDatabase::class.java,
                        "scores_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}