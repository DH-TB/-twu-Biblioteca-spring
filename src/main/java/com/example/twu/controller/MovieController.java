package com.example.twu.controller;

import com.example.twu.entities.Movie;
import com.example.twu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/movies")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieRepository.addMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/movies")
    public ResponseEntity getMovies() {
        return new ResponseEntity<>(movieRepository.getMovies(), HttpStatus.OK);
    }
}
