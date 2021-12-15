package com.webdoc.assignment.MovieListScreens.RoomDataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.webdoc.assignment.MovieListScreens.Dao.MovieDao;
import com.webdoc.assignment.MovieListScreens.Essentials.Converters;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;

@Database(entities = Result.class, version = 1, exportSchema = false)
@TypeConverters({Converters.class})

public abstract class MoviesRoomDataBase extends RoomDatabase {

    private static MoviesRoomDataBase dataBase;

    public static synchronized MoviesRoomDataBase getDataBase(Context context) {

        if (dataBase == null) {
            dataBase = Room.databaseBuilder(context, MoviesRoomDataBase.class, "Movie_DB").build();
        }
        return dataBase;
    }

    public abstract MovieDao movieDao();
}
