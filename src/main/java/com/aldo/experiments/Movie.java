package com.aldo.experiments;

import java.util.ArrayList;

public class Movie{
    private int movieId;
    private float rating;
    private ArrayList<Movie> similarMovies=new ArrayList<>();

    public int getMovieId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public ArrayList<Movie> getSimilarMovies() {
        return similarMovies;
    }

    public Movie(int movieId, float rating){
        this.movieId = movieId;
        this.rating = rating;
    }

    public void addSimilarMovie(Movie movie){
        similarMovies.add(movie);
    }

    @Override
    public String toString() {
        return String.format("%d - %f", getMovieId(), getRating());
    }
}
