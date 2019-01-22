package com.pratik.moviesapp.controller

import com.pratik.moviesapp.models.Movie
import com.pratik.moviesapp.rest.MoviesEndPoints
import com.pratik.moviesapp.rest.RetrofitInstance

import java.io.IOException

object MovieController : IMovieController {

    @Throws(IOException::class)
    override fun moviesPopular(): Movie {
        val api = RetrofitInstance.getRetrofit().create(MoviesEndPoints::class.java)
        val call = api.getPopularMovies(API_KEY)
        return call.execute().body()!!
    }

    @Throws(IOException::class)
    override fun topRatedMovies() : Movie {
        val api = RetrofitInstance.getRetrofit().create(MoviesEndPoints::class.java)
        val call = api.getTopRatedMovies(API_KEY)
        return call.execute().body()!!
    }


        private const val API_KEY = "c948b84bfc921249fca1312ae756d3de"
}
