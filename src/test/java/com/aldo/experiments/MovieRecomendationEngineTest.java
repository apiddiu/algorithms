package com.aldo.experiments;

import org.junit.Test;

public class MovieRecomendationEngineTest {

    @Test
    public void aaa(){
        MovieRecomendationEngine mre = new MovieRecomendationEngine();

        System.out.println(mre.getMovieRecommendations(getMovie(), 3));
    }

    /*
            5.0
          /    \
       4.8      5.2
      /   \    /   \
   5.1   5.3  4.7   4.5
     */
    private Movie getMovie() {
        Movie m51 = new Movie(51, 5.1f);
        Movie m53 = new Movie(53, 5.3f);

        Movie m47 = new Movie(47, 4.7f);

        Movie m45 = new Movie(45, 4.5f);
        Movie m48 = new Movie(48, 4.8f);

        Movie m52 = new Movie(52, 5.2f);

        Movie m50 = new Movie(50, 5.0f);

        m48.addSimilarMovie(m51);
        m48.addSimilarMovie(m53);

        m52.addSimilarMovie(m47);
        m52.addSimilarMovie(m45);
//        m52.addSimilarMovie(m53);

        m50.addSimilarMovie(m48);
        m50.addSimilarMovie(m52);

        return m50;
    }
}
