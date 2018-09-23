package com.example.twu.demo.entities;

public class CheckoutMovie {
    private String userId;
    private int movieId;


    public CheckoutMovie(String userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }
}
