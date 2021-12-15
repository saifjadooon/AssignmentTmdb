package com.webdoc.assignment.MovieListScreens;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.webdoc.assignment.MovieListScreens.Adapters.MoviesAdapter;
import com.webdoc.assignment.MovieListScreens.Essentials.Constants;
import com.webdoc.assignment.MovieListScreens.Essentials.Global;
import com.webdoc.assignment.MovieListScreens.RoomDataBase.MoviesRoomDataBase;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;
import com.webdoc.assignment.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MovieListViewModel viewModel;
    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitViews();
        Observer();

    }

    private void InitViews() {

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        Constants.context = MainActivity.this;

        if (Constants.isInternetConnected(this)) {
            Global.showProgressDialog(MainActivity.this, "Please wait while we are fetchin data");
            viewModel.GetUpcomingMoviesData();

        } else {

            getMovies();
        }

    }

    private void Observer() {


        viewModel.LD_UpComingMovies().observe(this, response -> {

            if (response != null) {

                saveData(response.getResults());
                Global.hideProgressDialog();
            }
        });

    }

    private void saveData(List<Result> results) {


        @SuppressLint("StaticFieldLeak")
        class getNotesTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {


                MoviesRoomDataBase.getDataBase(MainActivity.this).movieDao().Insert(results);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getMovies();
            }
        }

        new getNotesTask().execute();
    }

    private void getMovies() {
        @SuppressLint("StaticFieldLeak")
        class getNotesTask extends AsyncTask<Void, Void, List<Result>> {

            @Override
            protected List<Result> doInBackground(Void... voids) {
                return MoviesRoomDataBase.getDataBase(MainActivity.this).movieDao().getAllMovies();
            }

            @Override
            protected void onPostExecute(List<Result> movies) {
                super.onPostExecute(movies);

                Global.videosList.addAll(movies);
                SetRecyclerView();


                Log.i("ffd", movies.toString());
            }
        }

        new getNotesTask().execute();
    }


    public void SetRecyclerView() {

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        binding.rvMovies.setLayoutManager(layoutManager2);
        binding.rvMovies.setHasFixedSize(true);
        adapter = new MoviesAdapter(MainActivity.this, Global.videosList);                //initialize main adapter
        binding.rvMovies.setAdapter(adapter);
    }


}

