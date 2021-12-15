package com.webdoc.assignment.MovieListScreens;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.webdoc.assignment.MovieListScreens.Essentials.Constants;
import com.webdoc.assignment.MovieListScreens.Essentials.Global;
import com.webdoc.assignment.MovieListScreens.Retrofit.APIInterface;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.UpComingMoviesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListViewModel extends AndroidViewModel {

    private final MutableLiveData<UpComingMoviesResponse> MLD_UpCommingMovies = new MutableLiveData<>();

    public LiveData<UpComingMoviesResponse> LD_UpComingMovies() {
        return MLD_UpCommingMovies;
    }


    public MovieListViewModel(@NonNull Application application) {
        super(application);
    }

    public void GetUpcomingMoviesData() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient();
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client) // Set HttpClient to be used by Retrofit
                .build();

        APIInterface jsonPlaceHolderApi = retrofit.create(APIInterface.class);
        Call<UpComingMoviesResponse> call1 = jsonPlaceHolderApi.GetUpcomingMoviesData(Constants.ApiKey);

        call1.enqueue(new Callback<UpComingMoviesResponse>() {
            @Override
            public void onResponse(Call<UpComingMoviesResponse> call, Response<UpComingMoviesResponse> response) {


                UpComingMoviesResponse logoutResponse = response.body();
                MLD_UpCommingMovies.postValue(logoutResponse);
                Global.upComingMoviesResponse = logoutResponse;
                List<Result> list = new ArrayList<>();
                for (int i = 0; i < logoutResponse.getResults().size(); i++) {
                    list.add(logoutResponse.getResults().get(i));
                }
                Global.videosList = list;

                if (!response.isSuccessful()) {
                    Toast.makeText(Constants.context, response.message() + "", Toast.LENGTH_SHORT).show();

                    Log.i("Failure", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<UpComingMoviesResponse> call, Throwable t) {
                Toast.makeText(Constants.context, t + "", Toast.LENGTH_SHORT).show();
                Log.d("fai;", t + "");
                call.cancel();
            }
        });
    }


}


