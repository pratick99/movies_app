package com.pratik.moviesapp.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.pratik.moviesapp.controller.MovieCallBack;
import com.pratik.moviesapp.controller.MovieController;
import com.pratik.moviesapp.models.Movie;

import retrofit2.Call;


public class MovieListViewModel extends AndroidViewModel{

    private MovieController movieController;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        movieController = MovieController.getMovieController();
    }

    public Call<Movie> getPopularMovies(final MovieCallBack callBack) {
        return movieController.moviesPopular(callBack);
    }

    public Call<Movie> getTopRatedMovies(final MovieCallBack callBack) {
        return movieController.getTopRatedMovies(callBack);
    }
}
