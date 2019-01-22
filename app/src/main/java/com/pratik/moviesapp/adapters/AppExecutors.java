package com.pratik.moviesapp.adapters;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class AppExecutors {

    private Executor diskIO;
    private Executor networkIO;
    private Executor mainThread;
    private static AppExecutors appExecutors;

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public static AppExecutors getInstance() {
        if (appExecutors == null) {
            appExecutors = new AppExecutors(Executors.newSingleThreadExecutor(),
                    Executors.newFixedThreadPool(3),
                    new MainThreadExecutor());
        }
        return appExecutors;
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private android.os.Handler mainThreadHandler = new android.os.Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }
}
