package com.pratik.moviesapp.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.pratik.moviesapp.models.Movie;


public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;

    MovieListViewModel(MovieRepository repository) {
        super();
        this.movieRepository = repository;
    }

    public Movie syncPopularMovies() {
       return movieRepository.getPopularMovies();
    }

    public Movie syncTopRatedMovies() {
        return movieRepository.getTopRatedMovies();
    }
}
