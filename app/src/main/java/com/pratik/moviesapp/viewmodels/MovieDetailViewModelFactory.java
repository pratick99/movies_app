package com.pratik.moviesapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MovieDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private MovieRepository movieRepository;

    public MovieDetailViewModelFactory(MovieRepository repository) {
        this.movieRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MovieDetailsViewModel(movieRepository);
    }}
