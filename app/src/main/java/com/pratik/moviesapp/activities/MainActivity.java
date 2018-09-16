package com.pratik.moviesapp.activities;


import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.adapters.MoviesListAdapter;
import com.pratik.moviesapp.controller.MovieCallBack;
import com.pratik.moviesapp.models.Movie;
import com.pratik.moviesapp.models.Results;
import com.pratik.moviesapp.viewmodels.MovieListViewModel;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements MovieCallBack {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesListRecyclerView;

    private static final int SPAN_COUNT = 2;
    private Call<Movie> popularMovieCall;
    private Call<Movie> topRatedMovieCall;
    private List<Results> popularMovies;
    private List<Results> topRatedMovies;
    private MoviesListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MovieListViewModel movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        popularMovieCall = movieListViewModel.getPopularMovies(this);
        topRatedMovieCall = movieListViewModel.getTopRatedMovies(this);
    }

    @Override
    public void getPopularMovies(@NonNull Movie movie) {
        popularMovies = Arrays.asList(movie.getResults());
    }

    @Override
    public void getTopRateMovies(@NonNull Movie movie) {
        topRatedMovies = Arrays.asList(movie.getResults());
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        Log.wtf(TAG, throwable.getLocalizedMessage());
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
        if(topRatedMovies != null) {
            listAdapter = new MoviesListAdapter(topRatedMovies, getApplicationContext());
            moviesListRecyclerView.setHasFixedSize(true);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), SPAN_COUNT);
        moviesListRecyclerView.setLayoutManager(layoutManager);
        moviesListRecyclerView.setAdapter(listAdapter);
    }

    private void loadPopularMoviesList() {
        if(popularMovies != null) {
            listAdapter = new MoviesListAdapter(popularMovies, getApplicationContext());
            moviesListRecyclerView.setHasFixedSize(true);

        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), SPAN_COUNT);
        moviesListRecyclerView.setLayoutManager(layoutManager);
        moviesListRecyclerView.setAdapter(listAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        popularMovieCall.cancel();
        topRatedMovieCall.cancel();
    }
}
