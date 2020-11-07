package com.pratik.moviesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pratik.moviesapp.controller.MovieCallBack
import com.pratik.moviesapp.controller.MovieController
import com.pratik.moviesapp.models.Movie
import retrofit2.Call

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    fun getPopularMovies(callBack: MovieCallBack?): Call<Movie?>? {
        return callBack?.let { MovieController.moviesPopular(it) }
    }

    fun getTopRatedMovies(callBack: MovieCallBack?): Call<Movie?>? {
        return callBack?.let { MovieController.getTopRatedMovies(it) }
    }

}