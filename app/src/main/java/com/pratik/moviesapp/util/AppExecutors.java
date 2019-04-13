package com.pratik.moviesapp.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppExecutors {

    private Executor diskIO;
    private Executor mainThread;
    private Executor networkIO;
    private static AppExecutors appExecutors;

    private AppExecutors(final Executor diskIO, final Executor mainThread, final Executor networkIO) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public AppExecutors getInstance() {
        if(appExecutors == null) {
            appExecutors = new AppExecutors(new ThreadPoolExecutor(1,3,30_000, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3)), new MainThreadHandler(),
                    Executors.newFixedThreadPool(3));
        }
        return appExecutors;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    private class MainThreadHandler implements Executor {

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());


        @Override
        public void execute(@NonNull Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }
}
