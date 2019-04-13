package com.pratik.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pratik.moviesapp.R;
import com.pratik.moviesapp.activities.DetailsActivity;
import com.pratik.moviesapp.models.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author pratik-personal
 */
public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder> {

    private final List<Results> movies;
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w185";
    private Context context;

    public MoviesListAdapter(final List<Results> popularMovies, final Context appContext) {
        super();
        this.movies = popularMovies;
        this.context = appContext;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.movie_grid_view, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Results results = movies.get(position);
        if((results != null)) {
            String path = results.getPoster_path();
            Picasso.with(context).load(IMAGE_URL+path).into(holder.movieImage);
            holder.movieName.setText(results.getOriginal_title());
        }

        holder.itemView.setOnClickListener(view -> {
            Bundle detailsBundle = new Bundle();
            detailsBundle.putParcelable("movie", results);
            Intent detailsIntent = new Intent(context, DetailsActivity.class);
            detailsIntent.putExtras(detailsBundle);
            context.startActivity(detailsIntent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_image)
        ImageView movieImage;

        @BindView(R.id.movie_name)
        TextView movieName;

        MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
