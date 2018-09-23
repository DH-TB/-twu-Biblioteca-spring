package com.example.twu.repository.storage;

import com.example.twu.entities.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieStorage {
    private static final Map<Integer, Movie> MOVIES = new HashMap<>();

    public static void clear() {
        MOVIES.clear();
    }

    public static Collection<Movie> getMovies() {
        return MOVIES.values();
    }

    public static int getSize() {
        return MOVIES.size();
    }

    public static Movie addMovie(Movie movie) {
        MOVIES.put(movie.getId(), movie);
        return movie;
    }
}
