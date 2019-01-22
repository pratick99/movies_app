package com.pratik.moviesapp.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.injections.InjectionUtil;
import com.pratik.moviesapp.models.Results;
import com.pratik.moviesapp.viewmodels.MovieDetailViewModelFactory;
import com.pratik.moviesapp.viewmodels.MovieDetailsViewModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = DetailsActivity.class.getSimpleName();
  

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.movie_title_text)
    TextView titleText;

    @BindView(R.id.movie_description_text)
    TextView movieDescription;

    @BindView(R.id.movie_user_ratings_text)
    TextView userRatings;

    @BindView(R.id.release_date_text)
    TextView releaseDate;

    @BindView(R.id.movie_image_view)
    ImageView movieImage;

    @BindView(R.id.reviewsList)
    RecyclerView reviewsLists;

    @BindView(R.id.trailersList)
    RecyclerView trailersList;

    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w780/";
    private MovieDetailsViewModel movieDetailsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        toolbar.setTitle("Movie Details");
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Results results = intent.getParcelableExtra("movie");
        Picasso.with(this).load(IMAGE_URL + results.getPoster_path()).into(movieImage);
        titleText.setText(results.getOriginal_title());
        movieDescription.setText(results.getOverview());
        userRatings.setText(results.getVote_average());
        releaseDate.setText(results.getRelease_date());
        Log.i(TAG, results.toString());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    protected void onResume() {
        super.onResume();
        MovieDetailViewModelFactory factory = InjectionUtil.geMovieDetailViewModelFactory(getApplicationContext());
        movieDetailsViewModel = ViewModelProviders.of(this, factory).get(MovieDetailsViewModel.class);
    }

    @OnClick(R.id.save_as_favorite)
    public void saveAsFavorite() {

    }
}
