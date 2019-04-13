package com.pratik.moviesapp.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.pratik.moviesapp.adapters.AppExecutors;
import com.pratik.moviesapp.controller.IMovieController;
import com.pratik.moviesapp.database.MovieDatabase;
import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.models.Results;

import java.io.IOException;

/**
 * @author pratik-personal
 */
public class MovieRepository {

    private final static String LOG_TAG = MovieRepository.class.getSimpleName();
    private final MovieDatabase moviedatabase;
    private Context context;
    private IMovieController movieController;
    private MutableLiveData<Movie> popularMovies;
    private MutableLiveData<Movie> topRatedMovies;
    private AppExecutors appExecutors;
    private static MovieRepository movieRepository;

    private MovieRepository(Context context, MovieDatabase movieDatabase,
                           IMovieController movieController, AppExecutors appExecutors) {
        this.context  = context;
        this.moviedatabase = movieDatabase;
        this.appExecutors = appExecutors;
        this.movieController = movieController;
        this.popularMovies = new MutableLiveData<>();
        this.topRatedMovies = new MutableLiveData<>();
    }


    public static synchronized MovieRepository getInstance(Context context, MovieDatabase movieDatabase,
                                              IMovieController movieController, AppExecutors appExecutors) {
        if(movieRepository == null) {
            movieRepository = new MovieRepository(context, movieDatabase, movieController, appExecutors);
        }

        return movieRepository;

    }


    Movie getPopularMovies() {
        initPopularMovies();
        return popularMovies.getValue();
    }

    private synchronized void initPopularMovies() {
        appExecutors.getNetworkIO().execute(() -> {
            try {
                popularMovies.postValue(movieController.moviesPopular());
            } catch (IOException e) {
                Log.e(LOG_TAG, e.getLocalizedMessage());
            }
        });

    }

    Movie getTopRatedMovies() {
        syncTopRatedMovies();
        return topRatedMovies.getValue();
    }

    private synchronized void syncTopRatedMovies() {
        appExecutors.getNetworkIO().execute(() -> {
            try {
                topRatedMovies.postValue(movieController.topRatedMovies());
            } catch (IOException e) {
                Log.e(LOG_TAG, e.getLocalizedMessage());
            }
        });

    }

    void saveAsFavorite(Results movie) {
        appExecutors.getDiskIO().execute(() -> moviedatabase.movieDao().addPopularMovie(movie));
    }
}
