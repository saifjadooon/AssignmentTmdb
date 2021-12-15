package com.webdoc.assignment.MovieListScreens.Essentials;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.widget.ProgressBar;

import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.UpComingMoviesResponse;

import java.util.ArrayList;
import java.util.List;

public class Global {

    public static ProgressDialog progressDialog;

    public static UpComingMoviesResponse upComingMoviesResponse = new UpComingMoviesResponse();
    public static List<Result> videosList = new ArrayList();
    public static int position;

    public static void showProgressDialog(Activity activity, String message) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
        ProgressBar progressbar = progressDialog.findViewById(android.R.id.progress);
        progressbar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#d32e33"), android.graphics.PorterDuff.Mode.SRC_IN);
    }


    public static void hideProgressDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

}
