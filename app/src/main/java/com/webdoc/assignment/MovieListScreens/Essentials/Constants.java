package com.webdoc.assignment.MovieListScreens.Essentials;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import com.webdoc.assignment.MovieListScreens.MainActivity;

public class Constants {
    public static String BaseUrl = "https://api.themoviedb.org/3/";
    public static String ApiKey = "ec272bceb662183a13fa3f2ee30d5721";
    public static String GetUpdatedMovies = "upcoming?api_key=" + ApiKey;
    public static MainActivity context;

    public static boolean isInternetConnected(Activity cntx) {
        ConnectivityManager cm = (ConnectivityManager) cntx.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
