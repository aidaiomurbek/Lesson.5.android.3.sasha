package com.example.lesson5android3sasha.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lesson5android3sasha.data.model.FilmModel;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM filmModel")
    List<FilmModel> getFilms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilms(FilmModel model);
}
