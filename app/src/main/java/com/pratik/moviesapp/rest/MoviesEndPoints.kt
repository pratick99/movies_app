package com.pratik.moviesapp.rest

import com.pratik.moviesapp.models.Movie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesEndPoints {


    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<Movie>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<Movie>
}
