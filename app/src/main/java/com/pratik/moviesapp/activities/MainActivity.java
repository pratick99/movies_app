package com.pratik.moviesapp.activities;


import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.adapters.MoviesListAdapter;
import com.pratik.moviesapp.controller.MovieCallBack;
import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.models.Results;
import com.pratik.moviesapp.rest.MoviesEndPoints;
import com.pratik.moviesapp.viewmodels.MovieListViewModel;

import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesList;

    private static final String TAG = MainActivity.class.getSimpleName();
    private MovieListViewModel movieListViewModel;
    private MoviesListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final int SPAN_COUNT = 2;
    private List<Results> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        movieListViewModel.getPopularMovies(new MovieCallBack() {
            @Override
            public void onSuccess(@NonNull Movie movie) {
                movies = Arrays.asList(movie.getResults());
                listAdapter = new MoviesListAdapter(movies);
                moviesList.setHasFixedSize(true);
                layoutManager = new GridLayoutManager(getApplicationContext(), SPAN_COUNT);
                moviesList.setLayoutManager(layoutManager);
                moviesList.setAdapter(listAdapter);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Log.wtf(TAG, throwable.getLocalizedMessage());
            }
        });


    }
}
