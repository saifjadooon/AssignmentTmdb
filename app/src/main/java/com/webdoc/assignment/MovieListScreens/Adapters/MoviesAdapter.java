package com.webdoc.assignment.MovieListScreens.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.webdoc.assignment.MovieListScreens.Essentials.Global;
import com.webdoc.assignment.MovieListScreens.SeeMovieDetailActivity;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.Result;
import com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse.UpComingMoviesResponse;
import com.webdoc.assignment.R;

import java.util.ArrayList;
import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    Context context;
    List<Result> list;

    public MoviesAdapter(Context context, List<Result> videosList) {
        this.list = videosList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moview_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        /*for (int i = 0; i < data.getResults().size(); i++) {
            list.add(data.getResults().get(i));
        }*/

        holder.tvMoviewName.setText(list.get(position).getOriginalTitle() + "");
        String imageUrl = "https://image.tmdb.org/t/p/w500" + list.get(position).getPosterPath();
        Picasso.get().load(imageUrl).placeholder(R.color.black).into(holder.iv_image);

        holder.tvReleaseDate.setText("Release Date: " + list.get(position).getReleaseDate());
        holder.tvVoteAverage.setText("Vote Average: " + list.get(position).getVoteAverage().toString());
        holder.tvOVerView.setText("Overview: " + list.get(position).getOverview());
        holder.tv_MovieId.setText("ID: " + list.get(position).getId());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SeeMovieDetailActivity.class);
                intent.putExtra("movieTitle", list.get(position).getOriginalTitle() + "");
                intent.putExtra("imageurl", imageUrl);
                intent.putExtra("releaseDate", "Release Date: " + list.get(position).getReleaseDate());
                intent.putExtra("voteAverage", "Vote Average: " + list.get(position).getVoteAverage().toString());
                intent.putExtra("Overview", "Overview: " + list.get(position).getOverview());
                intent.putExtra("Id", "ID: " + list.get(position).getId());
                intent.putExtra("language", "Language: " + list.get(position).getOriginalLanguage());
                intent.putExtra("adult", "Adult: " + list.get(position).getAdult());
                context.startActivity(intent);
                Global.position = position;

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
        // return Global.upComingMoviesResponse.getTotalResults();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMoviewName, tvReleaseDate, tvVoteAverage, tvOVerView, tv_MovieId;
        ImageView iv_image;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMoviewName = itemView.findViewById(R.id.tvMoviewName);
            iv_image = itemView.findViewById(R.id.imageView2);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvVoteAverage = itemView.findViewById(R.id.tvVoteAverage);
            tvOVerView = itemView.findViewById(R.id.tvOVerView);
            tv_MovieId = itemView.findViewById(R.id.tv_MovieId);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }

}