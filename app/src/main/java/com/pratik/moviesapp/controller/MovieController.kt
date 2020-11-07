package com.pratik.moviesapp.controller

import android.util.Log
import com.pratik.moviesapp.models.Movie
import com.pratik.moviesapp.rest.MoviesEndPoints
import com.pratik.moviesapp.rest.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieController {


    fun moviesPopular(callBack: MovieCallBack): Call<Movie?>? {
        val api = RetrofitInstance.getRetrofitInstance().create(MoviesEndPoints::class.java)
        val call = api.getPopularMovies(API_KEY)
        call.enqueue(object : Callback<Movie?> {
            override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                if (response.body() != null && call.isExecuted) {
                    response.body()?.let { callBack.getPopularMovies(it) }
                }
            }

            override fun onFailure(call: Call<Movie?>, t: Throwable) {
                if (call.isCanceled) {
                    callBack.onPopularMoviesError(t)
                }
                Log.wtf(TAG, t)
            }
        })
        return call
    }

    fun getTopRatedMovies(callBack: MovieCallBack): Call<Movie?>? {
        val api = RetrofitInstance.getRetrofitInstance().create(MoviesEndPoints::class.java)
        val call = api.getTopRatedMovies(API_KEY)
        call.enqueue(object : Callback<Movie?> {
            override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                if (response.body() != null && call.isExecuted) {
                    response.body()?.let { callBack.getTopRateMovies(it) }
                }
            }

            override fun onFailure(call: Call<Movie?>, t: Throwable) {
                if (call.isCanceled) {
                    callBack.onTopRatedMoviesError(t)
                }
                Log.wtf(TAG, t)
            }
        })
        return call
    }


    private val TAG = MovieController::class.java.simpleName
    private const val API_KEY = ""
}