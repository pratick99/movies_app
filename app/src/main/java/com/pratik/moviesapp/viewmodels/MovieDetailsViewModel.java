package com.pratik.moviesapp.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.pratik.moviesapp.models.Results;

/**
 * @author pratik-personal
 */
public class MovieDetailsViewModel extends ViewModel {

    private MovieRepository repository;

    MovieDetailsViewModel(MovieRepository repository) {
        this.repository = repository;
    }

    public void saveAsFavorite(Results movie) {
        repository.saveAsFavorite(movie);
    }
}
