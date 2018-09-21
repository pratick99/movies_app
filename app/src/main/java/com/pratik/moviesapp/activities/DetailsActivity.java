package com.pratik.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.Util;
import com.pratik.moviesapp.models.Results;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public static final String IMAGE_URL = "http://image.tmdb.org/t/p/w780/";

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
    }

}
