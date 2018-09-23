package com.example.twu.repository;

import com.example.twu.entities.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie addMovie(Movie movie);

    Collection<Movie> getMovies();

    boolean containsMovie(Integer movieId);
}
