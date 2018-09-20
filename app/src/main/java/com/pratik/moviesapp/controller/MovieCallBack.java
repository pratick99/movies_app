package com.pratik.moviesapp.controller;

import android.support.annotation.NonNull;

import com.pratik.moviesapp.models.Movie;


public interface MovieCallBack {

    void getPopularMovies(@NonNull Movie movie);

    void getTopRateMovies(@NonNull Movie movie);

    void onPopularMoviesError(@NonNull Throwable throwable);

    void onTopRatedMoviesError(@NonNull Throwable t);
}
