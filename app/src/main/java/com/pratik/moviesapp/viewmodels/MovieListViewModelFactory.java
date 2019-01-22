package com.pratik.moviesapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MovieListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final MovieRepository  mRepository;

    public MovieListViewModelFactory(MovieRepository repository) {
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MovieListViewModel(mRepository);
    }

}
