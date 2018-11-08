package com.pratik.moviesapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log

import com.pratik.moviesapp.models.Results

@Database(entities = [Results::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    companion object {

        private val LOG_TAG = MovieDatabase::class.java.simpleName
        private val DATABASE_NAME = "movie"
        private var sInstance: MovieDatabase? = null
        private val LOCK = Any()
    }

    fun getInstance(context: Context): MovieDatabase {
        Log.d(LOG_TAG, "Getting the database")
        if (sInstance == null) {
            synchronized(LOCK) {
                sInstance = Room.databaseBuilder<MovieDatabase>(context.applicationContext,
                        MovieDatabase::class.java, MovieDatabase.DATABASE_NAME).build()
                Log.d(LOG_TAG, "Made new database")
            }
        }
        return sInstance!!
    }


}
