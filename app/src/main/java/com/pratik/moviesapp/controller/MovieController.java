package com.pratik.moviesapp.controller;

import android.support.annotation.NonNull;
import android.util.Log;

import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.rest.MoviesEndPoints;
import com.pratik.moviesapp.rest.RetrofitInstance;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.pratik.moviesapp.Util.API_KEY;


public class MovieController {

    private static final String TAG = MovieController.class.getSimpleName();
    private static MovieController movieController =null;

    private MovieController() {
        super();
    }

    public static MovieController getMovieController() {
        if(movieController == null) {
            movieController = new MovieController();
        }

        return movieController;
    }

    public Call<Movie> moviesPopular(MovieCallBack callBack) {

        final MoviesEndPoints api = RetrofitInstance.getRetrofit().create(MoviesEndPoints.class);
        final Call<Movie> call = api.getPopularMovies(API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.body() != null && call.isExecuted()) {
                    callBack.getPopularMovies(Objects.requireNonNull(response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                if(call.isCanceled()) {
                    callBack.onPopularMoviesError(t);
                }
                Log.wtf(TAG, t.getLocalizedMessage());
            }
        });
        return call;
    }

    public Call<Movie> getTopRatedMovies(MovieCallBack callBack) {
        final MoviesEndPoints api = RetrofitInstance.getRetrofit().create(MoviesEndPoints.class);
        final Call<Movie> call = api.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if(response.body() != null && call.isExecuted()) {
                    callBack.getTopRateMovies(Objects.requireNonNull(response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                if(call.isCanceled()) {
                    callBack.onTopRatedMoviesError(t);
                }
                Log.wtf(TAG, t.getLocalizedMessage());
            }
        });

        return call;
    }

}
