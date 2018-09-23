package com.example.twu.repository.impl;

import com.example.twu.entities.Movie;
import com.example.twu.repository.MovieRepository;
import com.example.twu.repository.storage.MovieStorage;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Override
    public Movie addMovie(Movie movie) {
        return MovieStorage.addMovie(movie);
    }

    @Override
    public Collection<Movie> getMovies() {
        return MovieStorage.getMovies();
    }

    @Override
    public boolean containsMovie(Integer movieId) {
        return MovieStorage.containsMovie(movieId);
    }
}
