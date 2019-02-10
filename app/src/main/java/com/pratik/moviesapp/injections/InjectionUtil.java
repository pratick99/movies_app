package com.pratik.moviesapp.injections;

import android.content.Context;

import com.pratik.moviesapp.adapters.AppExecutors;
import com.pratik.moviesapp.controller.MovieController;
import com.pratik.moviesapp.database.MovieDatabase;
import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.viewmodels.MovieDetailViewModelFactory;
import com.pratik.moviesapp.viewmodels.MovieListViewModelFactory;
import com.pratik.moviesapp.viewmodels.MovieRepository;

import java.util.List;

public class InjectionUtil {

    public static MovieListViewModelFactory getMovieListViewModelFactory(final Context context) {
        MovieRepository movieRepository = getRepository(context);
        return new MovieListViewModelFactory(movieRepository);
    }

    public static MovieDetailViewModelFactory geMovieDetailViewModelFactory(final Context context) {
        MovieRepository movieRepository = getRepository(context);
        return new MovieDetailViewModelFactory(movieRepository);
    }

    private static MovieRepository getRepository(Context context) {
        MovieDatabase database = MovieDatabase.getInstance(context);
        MovieController movieController = MovieController.INSTANCE;
        AppExecutors appExecutors = AppExecutors.getInstance();
        return MovieRepository.getInstance(context, database, movieController, appExecutors);
    }

}
