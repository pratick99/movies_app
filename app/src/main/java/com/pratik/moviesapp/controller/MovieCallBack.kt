package com.pratik.moviesapp.controller

import com.pratik.moviesapp.models.Movie

interface MovieCallBack {
    fun getPopularMovies(movie: Movie)
    fun getTopRateMovies(movie: Movie)
    fun onPopularMoviesError(throwable: Throwable)
    fun onTopRatedMoviesError(t: Throwable)
}