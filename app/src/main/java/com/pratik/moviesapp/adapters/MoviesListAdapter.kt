package com.pratik.moviesapp.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import butterknife.BindView
import butterknife.ButterKnife
import com.pratik.moviesapp.R
import com.pratik.moviesapp.activities.DetailsActivity
import com.pratik.moviesapp.adapters.MoviesListAdapter.MovieViewHolder
import com.pratik.moviesapp.models.Results
import com.squareup.picasso.Picasso

class MoviesListAdapter(private val movies: List<Results>, private val context: Context) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_grid_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val results = movies[position]
        val path = results.poster_path
        Picasso.get().load(IMAGE_URL + path).into(holder.movieImage)
        holder.movieName?.text = results.original_title
        holder.itemView.setOnClickListener { view: View? ->
            val detailsBundle = Bundle()
            detailsBundle.putParcelable("movie", results)
            val detailsIntent = Intent(context, DetailsActivity::class.java)
            detailsIntent.putExtras(detailsBundle)
            context.startActivity(detailsIntent)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder internal constructor(itemView: View?) : ViewHolder(itemView!!) {
        @JvmField
        @BindView(R.id.movie_image)
        var movieImage: ImageView? = null

        @JvmField
        @BindView(R.id.movie_name)
        var movieName: TextView? = null

        init {
            ButterKnife.bind(this, itemView!!)
        }
    }

    companion object {
        private const val IMAGE_URL = "http://image.tmdb.org/t/p/w185"
    }
}