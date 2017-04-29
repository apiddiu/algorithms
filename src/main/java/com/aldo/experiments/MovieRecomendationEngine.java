package com.aldo.experiments;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieRecomendationEngine {
    public Set<Movie> getMovieRecommendations (Movie movie, int N)
    {
        Set<Movie> topOfRelated = movie.getSimilarMovies().stream()
            .map(m -> getMovieRecommendations(m, N)).flatMap(m -> m.stream())
            .sorted(this::compareReverse)
            .limit(N)
            .collect(Collectors.toSet());

        topOfRelated.addAll(getTopRatedMovies(movie.getSimilarMovies() ,N));

        return topOfRelated.stream()
            .sorted(this::compareReverse)
            .limit(N)
            .collect(Collectors.toSet());
    }

    private Set<Movie> getTopRatedMovies(ArrayList<Movie> movies, int N){
        return movies.stream()
            .sorted(this::compareReverse)
            .limit(N)
            .collect(Collectors.toSet());
    }

    private int compareReverse(Movie m1, Movie m2){
        return Float.compare(m2.getRating(), m1.getRating());
    }
}
