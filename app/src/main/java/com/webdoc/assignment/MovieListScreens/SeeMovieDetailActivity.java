package com.webdoc.assignment.MovieListScreens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.webdoc.assignment.R;
import com.webdoc.assignment.databinding.ActivitySeeMovieDetailBinding;

public class SeeMovieDetailActivity extends AppCompatActivity {

    ActivitySeeMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitViews();
    }

    private void InitViews() {

        binding = ActivitySeeMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvMoviewName.setText(getIntent().getExtras().getString("movieTitle"));
        Picasso.get().load(getIntent().getExtras().getString("imageurl")).placeholder(R.color.black).into(binding.imageView2);
        binding.tvReleaseDate.setText(getIntent().getExtras().getString("releaseDate"));
        binding.tvVoteAverage.setText(getIntent().getExtras().getString("voteAverage"));
        binding.tvOVerView.setText(getIntent().getExtras().getString("Overview"));
        binding.tvMovieId.setText(getIntent().getExtras().getString("Id"));
        binding.tvLanguage.setText(getIntent().getExtras().getString("language"));
        binding.tvAdult.setText(getIntent().getExtras().getString("adult"));
    }
}