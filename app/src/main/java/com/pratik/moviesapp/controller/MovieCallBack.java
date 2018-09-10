package com.pratik.moviesapp.controller;

import android.support.annotation.NonNull;

import com.pratik.moviesapp.models.Movie;


public interface MovieCallBack {

    void onSuccess(@NonNull Movie movie);

    void onError(@NonNull Throwable throwable);
}
