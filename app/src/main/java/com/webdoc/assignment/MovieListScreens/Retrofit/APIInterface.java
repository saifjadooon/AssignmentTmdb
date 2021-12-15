package com.webdoc.assignment.MovieListScreens.Retrofit;

import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.UpComingMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {


    @GET("movie/upcoming?")
    Call<UpComingMoviesResponse>
    GetUpcomingMoviesData(
            @Query("api_key") String apiKey
    );
}
