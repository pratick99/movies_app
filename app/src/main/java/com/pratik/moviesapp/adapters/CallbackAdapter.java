package com.pratik.moviesapp.adapters;


import android.support.annotation.NonNull;
import android.util.Log;

import java.net.HttpURLConnection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackAdapter<T> implements Callback<T>{
    private static final String TAG = CallbackAdapter.class.getSimpleName();
    private Consumer<T> onSuccessConsumer;
    private Consumer<Response<T>> errorResponseHandler;
    private BiConsumer<Call<T>, Throwable> callFailureHandler;

    protected CallbackAdapter(Consumer<T> onSuccessConsumer, Consumer<Response<T>> errorResponseHandler,
                              BiConsumer<Call<T>, Throwable> callFailureHandler) {
        super();
        this.onSuccessConsumer = onSuccessConsumer;
        this.errorResponseHandler = errorResponseHandler;
        this.callFailureHandler = callFailureHandler;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if(response.code() == (HttpURLConnection.HTTP_OK | HttpURLConnection.HTTP_CREATED)) {
            onSuccessConsumer.accept(response.body());
        } else {
            errorResponseHandler.accept(response);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if(call.isCanceled()) {
            Log.d(TAG, call.request().toString());
        }
        Log.wtf(TAG, t.getLocalizedMessage());
    }
}
