package com.example.lesson5android3sasha;

import android.app.Application;

import androidx.room.Room;

import com.example.lesson5android3sasha.data.local.FilmDataBase;

public class App extends Application {

    public static App instance;

    private FilmDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBase = Room.databaseBuilder(this, FilmDataBase.class, "dataBase")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public FilmDataBase getDataBase() {
        return dataBase;
    }
}
