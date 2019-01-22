package com.pratik.moviesapp.activities;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.adapters.MoviesListAdapter;
import com.pratik.moviesapp.injections.InjectionUtil;
import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.models.Results;
import com.pratik.moviesapp.viewmodels.MovieListViewModel;
import com.pratik.moviesapp.viewmodels.MovieListViewModelFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesListRecyclerView;

    private static final int SPAN_COUNT = 2;
    private List<Results> popularMovies;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.containsKey("movies")) {
            popularMovies = new ArrayList<>(Objects.requireNonNull(savedInstanceState.getParcelableArrayList("movies")));
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MovieListViewModelFactory factory = InjectionUtil.getMovieListViewModelFactory(getApplicationContext());
        movieListViewModel = ViewModelProviders.of(this, factory).get(MovieListViewModel.class);
        movieListViewModel.syncPopularMovies();
        movieListViewModel.syncTopRatedMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.movie_list_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.popular:
                loadPopularMoviesList();
                return true;
            case R.id.top_rated:
                loadTopRatedMoviesList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadTopRatedMoviesList() {
        Movie popularMovies = movieListViewModel.syncPopularMovies();
        if(popularMovies != null) {
            List<Results> results = Arrays.asList(Objects.requireNonNull(popularMovies.getResults()));
            assignTheDataToAdapter(results);
        }
    }

    private void loadPopularMoviesList() {
        Movie topRatesMovies = movieListViewModel.syncTopRatedMovies();
        if(topRatesMovies != null) {
            List<Results> results = Arrays.asList(Objects.requireNonNull(topRatesMovies.getResults()));
            assignTheDataToAdapter(results);
        }
    }

    private void assignTheDataToAdapter(List<Results> results) {
        MoviesListAdapter listAdapter = new MoviesListAdapter(results, getApplicationContext());
        if(moviesListRecyclerView != null) {
            moviesListRecyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), SPAN_COUNT);
            moviesListRecyclerView.setLayoutManager(layoutManager);
            moviesListRecyclerView.setAdapter(listAdapter);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putParcelableArrayList("movies", (ArrayList<? extends Parcelable>) popularMovies);
        super.onSaveInstanceState(outState, outPersistentState);
    }

}
