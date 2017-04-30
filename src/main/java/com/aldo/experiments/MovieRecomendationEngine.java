package com.aldo.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieRecomendationEngine {
    public Set<Movie> getMovieRecommendations (Movie movie, int N)
    {
        return getMovieRecommendationsAvoidDuplicates(movie, N, new HashSet<>(Arrays.asList(movie)));
    }

    public Set<Movie> getMovieRecommendationsAvoidDuplicates(Movie movie, int N, Set<Movie> visited){
        Set<Movie> topOfRelated = movie.getSimilarMovies().stream()
                .filter(m -> !visited.contains(m))
                .map(m -> getMovieRecommendationsAvoidDuplicates(m, N, combine(visited, m.getSimilarMovies())))
                .flatMap(m -> m.stream())
                .sorted(this::compareReverse)
                .limit(N)
                .collect(Collectors.toSet());

        topOfRelated.addAll(getTopRatedMovies(movie.getSimilarMovies() ,N));

        return topOfRelated.stream()
                .sorted(this::compareReverse)
                .limit(N)
                .collect(Collectors.toSet());
    }

    private Set<Movie> combine(Set<Movie> visited, ArrayList<Movie> similarMovies) {
        visited.addAll(similarMovies);
        return visited;
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
