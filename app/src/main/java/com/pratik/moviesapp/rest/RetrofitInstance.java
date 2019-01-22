package com.pratik.moviesapp.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public final class RetrofitInstance {

    private static Retrofit retrofit = null;

    private RetrofitInstance() {
        super();
    }

    public static synchronized Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createAsync())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
