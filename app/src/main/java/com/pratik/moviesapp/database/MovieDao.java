package com.pratik.moviesapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.pratik.moviesapp.models.Results;

/**
 * @author Pratik Desai
 */
@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    LiveData<Results> getFavoriteMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPopularMovie(Results... movie);
}
