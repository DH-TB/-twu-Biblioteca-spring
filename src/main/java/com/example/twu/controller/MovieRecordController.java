package com.example.twu.controller;

import com.example.twu.entities.MovieRecord;
import com.example.twu.repository.MovieRecordRepository;
import com.example.twu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovieRecordController {

    @Autowired
    private MovieRecordRepository movieRecordRepository;
    @Autowired
    private MovieRepository movieRepository;


    @PostMapping("/movie-records")
    public ResponseEntity checkoutMovie(@RequestBody MovieRecord movieRecord) {
        if(movieRepository.containsMovie(movieRecord.getMovieId())) {
            movieRecordRepository.addRecord(movieRecord);
            return new ResponseEntity<>("Thank you! Enjoy the movie.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That movie is not available.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/movie-records/{movieRecordId}")
    public ResponseEntity returnBook(@PathVariable Integer movieRecordId) {
        if(movieRecordRepository.containsRecord(movieRecordId)) {
            movieRecordRepository.updateRecord(movieRecordId);
            return new ResponseEntity<>("Thank you for returning the movie.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That is not a valid movie to return.", HttpStatus.BAD_REQUEST);
    }
}
