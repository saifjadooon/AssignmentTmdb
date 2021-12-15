
package com.webdoc.assignment.MovieListScreens.UpComingMoviesResponse;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "MovieDetails")
public class Result implements Serializable {
    @PrimaryKey(autoGenerate = true)


    @SerializedName("adult")
    @Expose
    @ColumnInfo(name = "adult")
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    @ColumnInfo(name = "backdrop_path")
    private String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    @ColumnInfo(name = "genre_ids")
    private List<Integer> genreIds = null;
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private Integer id;
    @SerializedName("original_language")
    @Expose
    @ColumnInfo(name = "original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    @ColumnInfo(name = "original_title")
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    @ColumnInfo(name = "overview")
    private String overview;
    @SerializedName("popularity")
    @Expose
    @ColumnInfo(name = "popularity")
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    @ColumnInfo(name = "poster_path")
    private String posterPath;

    @SerializedName("release_date")
    @Expose
    @ColumnInfo(name = "release_date")
    private String releaseDate;
    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("video")
    @Expose
    @ColumnInfo(name = "video")
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    @ColumnInfo(name = "vote_average")
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    @ColumnInfo(name = "vote_count")
    private Integer voteCount;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

}
