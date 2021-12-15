package com.webdoc.assignment.MovieListScreens.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(List<Result> resultList);

    @Query("SELECT * FROM MovieDetails ")
    List<Result> getAllMovies();
}
