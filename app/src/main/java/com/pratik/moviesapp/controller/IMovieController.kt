package com.pratik.moviesapp.controller

import com.pratik.moviesapp.models.Movie
import java.io.IOException

interface IMovieController {

    @Throws(IOException::class)
    fun moviesPopular(): Movie

    @Throws(IOException::class)
    fun topRatedMovies(): Movie
}
