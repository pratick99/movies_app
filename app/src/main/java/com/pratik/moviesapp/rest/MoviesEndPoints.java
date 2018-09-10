package com.pratik.moviesapp.rest;

import com.pratik.moviesapp.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MoviesEndPoints {


    @GET("movie/popular")
    Call<Movie> popularMovies(@Query("api_key") String apiKey);
}
